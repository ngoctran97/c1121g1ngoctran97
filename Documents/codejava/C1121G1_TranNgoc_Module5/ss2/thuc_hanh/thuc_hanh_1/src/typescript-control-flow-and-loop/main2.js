var sum = 0;
var count = 0;
for (var i = 2; count < 30; i++) {
    var isPrime_1 = true;
    if (i == 2) {
        sum += i;
        count++;
        continue;
    }
    for (var j = 2; j <= Math.sqrt(i); j++) {
        if (i % j == 0) {
            isPrime_1 = false;
            break;
        }
    }
    if (!isPrime_1) {
        continue;
    }
    sum += i;
    count++;
}
console.log(sum);
//# sourceMappingURL=main2.js.map