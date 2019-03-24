"use strict";

function uniq(mass) {
    let obj = [];

    for (let i = 0; i < mass.length; i++) {
        if (Object.getPrototypeOf(mass[i]) === Object.prototype) {
            obj.push(mass[i]);
        }
    }
    for (let i = 0; i < obj.length; i++) {
        for (let j = 0; j < obj.length; j++) {
            if (JSON.stringify(obj[i]) === JSON.stringify(obj[j]) && i != j) {
                obj = obj.slice(j);
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

class Sets {
    constructor(...value) {
        this.mass = [];
        value.map(z => this.valid(z));
        this.mass = uniq(this.mass);
    }

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
        return this.mass.indexOf(value) > 0 ? true : false;
    }
    size() {
        return this.mass.length;
    }
    delete(value) {
        let index = this.mass.indexOf(value);
        index > 0 ? this.mass.splice(index, 1) : console.log("Не найдено");
        return this.mass;
    }
    clear() {
        this.mass = [];
    }
}

let mySet = new Sets({
    a: 20,
    b: 30
},
{
    a: 20,
    b: 30
 }, {
    b: 30,
    a: 228
}, 
{
    b: 30,
    a: 1337
}, [1, 2, 3], "ASD", "a");
//"ASD", [1, 2, 3], "JX", /*{ asd: "xxx" }*/ "ASD", "5", "5", "a", "a", [1, 2, 3],
console.log(mySet.add("QWASD"));
console.log(mySet.has("QWWSD"));
console.log(mySet.size(), mySet.mass, mySet.delete("a"));



