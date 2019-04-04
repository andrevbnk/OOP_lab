// function testi(){
//     return {a:30};
// }

// function tesing() {
//     return " x";
// }

// console.log(_.differenceWith(uniq(["A", "A", "a", "a", 1, 4, 8, 8]), [1, 4, 8, "A", "a"], _.isEqual));


let test = new Sets("ASD");
// console.log(test);
// test.valid("asd")


describe("clear", function () {
    it(`clear`, function () {
        assert.equal(String(test.clear()), String([]));
    });
});

describe("uniq", function () {
    it(`[1, 2, 3, "A", "S", 4, "D", "A", 2, "S", "D", "a", { a: 30, b: 228 }, { a: 30, b: 1337 }, { a: 30, b: 228 }] ____||____    [1, 2, 3, "A", 4, "S", "D", "a", { a: 30, b: 228 }, { a: 30, b: 1337 }]`, function () {
        assert.equal(String(_.differenceWith(uniq([1, 2, 3, "A", "S", 4, "D", "A", 2, "S", "D", "a", { a: 30, b: 228 }, { a: 30, b: 1337 }, { a: 30, b: 228 }]), [1, 2, 3, "A", 4, "S", "D", "a", { a: 30, b: 228 }, { a: 30, b: 1337 }], _.isEqual)), String([]));

    });
    it(`["A", "A", "a", "a", 1, 4, 8, 8] ____||____ [1, 4, 8, "A", "a"]`, function () {
        assert.equal(String(_.differenceWith(uniq(["A", "A", "a", "a", 1, 4, 8, 8]), [1, 4, 8, "A", "a"], _.isEqual)), String([]));
        // assert.equal(testi(),{a:30})
        // assert.equal(tesing(), " x");
    });

    it(`{a: 20,b: { a: 30, b: 30 }},{a: 20,b: { a: 30, b: 30 }}, {b: 30,a: 228},{b: 30,a: 228},{b: 30,a: 1337} ____||____  [{ a: 20, b: { a: 30, b: 30 } }, { b: 30, a: 228 }, { b: 30, a: 1337 }]`, function () {
        assert.equal(String(_.differenceWith(uniq(
            [{ a: 20, b: { a: 30, b: 30 } }, { a: 20, b: { a: 30, b: 30 } }, { b: 30, a: 228 }, { b: 30, a: 228 }, { b: 30, a: 1337 }]
        ), [{ a: 20, b: { a: 30, b: 30 } }, { b: 30, a: 228 }, { b: 30, a: 1337 }], _.isEqual)), String([]));
    });
});


describe("Valid return test.mass", function () {
    it(`test.valid("QWE");  ____||____  ["Q", "W", "E"]`, function () {
        // console.log(test.valid("ASD"));
        // console.log((function () { test.valid("QWE"); return test.mass; }()));
        assert.equal(String(_.differenceWith((function () { test.valid("QWE"); return test.mass; })(), ["Q", "W", "E"], _.isEqual)), String([]));
        test.mass = [];
    });

    it(`test.valid([1,2,3]);  ____||____  [1,2,3]`, function () {
        assert.equal(String(_.differenceWith((function () { test.valid([1, 2, 3]); return test.mass; })(), [1, 3, 2], _.isEqual)), String([]));
        test.mass = [];
    });

    it(`test.valid(3);____||____  [3]`, function () {
        assert.equal(String(_.differenceWith((function () { test.valid(3); return test.mass; })(), [3], _.isEqual)), String([]));
        test.mass = [];
    });

    it(`test.valid({a:30});  ____||____  [{a:30}]`, function () {
        assert.equal(String(_.differenceWith((function () { test.valid({ a: 30 }); return test.mass; })(), [{ a: 30 }], _.isEqual)), String([]));
        test.mass = [];
    });

    it(`Valid method = "add" test.valid("QWE);  ____||____  ["QWE"]`, function () {
        assert.equal(String(_.differenceWith((function () { test.valid("QWE", "add"); return test.mass; })(), ["QWE"], _.isEqual)), String([]));
        test.mass = [];
    });
});


describe("Has", function () {

    it(`False mass empty`, function () {
        test.mass = [];
        assert.equal(test.has("Q"), false);
    });

    it(`int False`, function () {
        test.mass = [1, 2, 3];
        assert.equal(test.has(5), false);
        test.mass = [];
    });

    it(`int True`, function () {
        test.mass = [1, 2, 3];
        assert.equal(test.has(2), true);
        test.mass = [];
    });

    it(`Object True`, function () {
        test.mass = [{ a: 30 }];
        assert.equal(test.has({ a: 30 }), true);
    });

    it(`Object False`, function () {
        test.mass = [{ a: 30 }, { b: 228 }];
        assert.equal(test.has({ b: 30 }), false);
    });
});


describe("Size", function () {
    it("[1,2,3,4] ____||____ 4", function () {
        test.mass = [1, 2, 3, 4];
        assert.equal(test.size(), 4);
        test.mass = [];
    });

    it("[] ____||____ 0", function () {
        test.mass = [];
        assert.equal(test.size(), 0);
        test.mass = [];
    });
});

describe("Delete", function () {
    it("Delet Int", function () {
        test.mass = [1, 2, 3];
        // console.log(test.delete(1));
        assert.equal(String(_.differenceWith(test.delete(1), [2, 3], _.isEqual)), String([]));
        test.mass = [];
    });

    it("Not found element", function () {
        test.mass = [1, 2, 3];
        assert.equal(test.delete(5), false);
        test.mass = [];
    });

    it("Delete Object", function () {
        test.mass = [{ a: 30 }, { a: 228 }, { b: 330 }];
        assert.equal(String(_.differenceWith(test.delete({ a: 30 }), [{ b: 330 }, { a: 228 }], _.isEqual)), String([]));
        test.mass = [];
    });

    it("Not found object", function () {
        test.mass = [{ a: 30 }, { a: 228 }, { b: 330 }];
        assert.equal(test.delete({ a: 229 }), false);
        test.mass = [];
    });
});
