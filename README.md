# BankAccount_Concurrency
BankAccount Thread-Safe
โจทย์ : สร้าง BankAccount ที่ Thread-Safe

1. สร้างคลาส BankAccount.java:       
        - มี balance = 0 ;
        - มีเมธอด deposit(amount)
        - มีเมธอด withdraw(amount) (ถ้าเงินไม่พอ ไม่ต้องทำอะไร)
        - มีเมธอด getBalance( )

2. ทำให้ Thread-Safe:
        - ใช้คีย์เวิร์ด synchronized กับเมธอดที่แก้ไข balance (deposit และ withdraw)

3. สร้าง Test Runner BankTest.java:
        - สร้าง BankAccount ขึ้นมา 1 บัญชี
        - สร้างเทรด 2-3 ตัวสำหรับ ฝากเงิน (Depositor) โดยแต่ละตัวจะฝากเงิน 1 บาท เป็นจำนวน 10,000 ครั้ง
        - สร้างเทรด 2-3 ตัวสำหรับ ถอนเงิน (Withdrawer) โดยแต่ละตัวจะถอนเงิน 1 บาท เป็นจำนวน 10,000 ครั้ง
        - ตัวอย่าง: ถ้ามี Depositor 2 ตัว และ Withdrawer 2 ตัว ยอดเงินสุดท้ายควรจะเป็น 0
        - ใช้ .start() เพื่อเริ่มเทรด และใช้ .join() เพื่อรอให้ทุกเทรดทำงานเสร็จ
        - พิมพ์ยอดเงินสุดท้าย (Final balance) ออกมาเพื่อตรวจสอบความถูกต้อง