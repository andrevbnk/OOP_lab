"use strict";

var objects = [{ 'x': 1, 'y': 2 }, { 'x': 2, 'y': 1 }, "A", "D"];

// console.log(_.differenceWith(objects, [{ 'x': 1, 'y': 2 }, "A"], _.isEqual));

function uniq(mass) {
    let obj = [];

    for (let i = 0; i < mass.length; i++) {
        if (Object.getPrototypeOf(mass[i]) === Object.prototype) {
            obj.push(mass[i]);
        }
    }

    for (let i = 0; i < obj.length; i++) {
        for (let j = 0; j < obj.length; j++) {
            if (i != j && _.isEqual(obj[i], obj[j])) {
                obj.splice(i, 1);
            }
        }
    }

    let all = {};
    let out = [];
    for (let i = 0; i < mass.length; i++) {
        if (all[mass[i]] != true && Object.getPrototypeOf(mass[i]) !== Object.prototype) {
            all[mass[i]] = true;
            out.push(mass[i])
        }
    }
    obj.map(el => out.push(el));
    return out;
}


class Method_Sets {
    valid(z, method) {
        if (typeof z == "string") {
            if (method == "add") {
                return this.mass.push(z);
            } else {
                return z.split("").map(b => this.mass.push(b));
            }
        } else if (Array.isArray(z)) {
            return z.map(b => this.mass.push(b))
        } else if (Object.getPrototypeOf(z) === Object.prototype || typeof z == "number") {
            return this.mass.push(z);
        } else {
            (function () {
                throw "=-(";
            });
        }
    }

    add(value) {
        this.valid(value, "add");
        this.mass = uniq(this.mass);
        return this.mass;
    }
    has(value) {
        if (Object.getPrototypeOf(value) === Object.prototype) {
            for (let i in this.mass) {
                if (_.isEqual(value, this.mass[i])) {
                    return true;
                }
            }
            return false;
        } else {
            return this.mass.indexOf(value) >= 0 ? true : false;
        }
    }
    size() {
        return this.mass.length;
    }
    delete(value) {
        if (Object.getPrototypeOf(value) === Object.prototype) {
            for (let i in this.mass) {
                if (_.isEqual(value, this.mass[i])) {
                    this.mass.splice(i, 1)
                    return this;
                }
            }
            return false;
        }
        else {
            let index = this.mass.indexOf(value);
            this.mass.splice(index, 1);
            return index >= 0 ? this.mass : false;
        }
    }
    clear() {
        this.mass = [];
        return this.mass;
    }

}
class Sets extends Method_Sets {
    constructor(...value) {
        super();
        this.mass = [];
        value.map(z => this.valid(z));
        // console.log(JSON.parse(JSON.stringify(this.mass)));
        this.mass = uniq(this.mass);
        // console.log(JSON.parse(JSON.stringify(this.mass)));
        return this;
    }
}

let mySet = new Sets({
    a: 20,
    b: { a: 30, b: 30 }
},
    {
        a: 20,
        b: { a: 30, b: 30 }
    }, {
        b: 30,
        a: 228
    },
    {
        b: 30,
        a: 228
    },
    {
        b: 30,
        a: 1337
    }, [1, 2, 3], "ASD", "a", 1, 2, 3, 4, 1, 2, 3);

"ASD", [1, 2, 3], "JX", /*{ asd: "xxx" }*/ "ASD", "5", "5", "a", "a", [1, 2, 3],
    console.log(mySet.add("QWASD"));
console.log(mySet.has("QWWSD"));
console.log(mySet.size(), JSON.parse(JSON.stringify(mySet.mass)), mySet.delete("a"));



