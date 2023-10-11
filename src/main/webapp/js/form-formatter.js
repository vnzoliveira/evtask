const vmMasker = window.VMasker;
const cardNum = document.getElementById('cardNum');
const expiryDate = document.getElementById('expiry-date');
const cvv = document.getElementById('cvv')
vmMasker(cardNum).maskPattern('9999 9999 9999 9999 9999');
vmMasker(expiryDate).maskPattern('99/99');
vmMasker(cvv).maskPattern('9999');