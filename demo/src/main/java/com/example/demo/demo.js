function solve(t, kArray) {
    const result = [];
    const alphabet = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ';

    for (let i = 0; i < t; i++) {

        let k = kArray[i] - 1;

        let columnName = '';

        while (k >= 0) {

            const remainder = k % 26;

            columnName = alphabet[remainder] + columnName;

            k = Math.floor(k / 26) - 1;

        }

        result.push(columnName);

    }

    return result;
}