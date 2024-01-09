package hus.oop.numbersystem;

import java.math.BigInteger;

public class BinaryConverter extends AbstractNumberConverter {
    public BinaryConverter(OriginalNumber originalNumber) {
        super(originalNumber);
    }

    /**
     * Chuyển đổi một số được biểu diễn trong hệ cơ số 10
     * sang số được biểu diễn trong hệ cơ số 2.
     *
     * @param decimal Số decimal cần chuyển đổi
     * @return xâu ký tự biểu diễn số trong hệ cơ số 2.
     *
     * Yêu cầu: sử dụng thuật toán Euclid để chuyển đổi,
     * không sử dụng thư viện chuyển đổi số có sẵn của Java.
     */
    @Override
    public String decimalTo(String decimal) {
        BigInteger decimalNumber = new BigInteger(decimal);

        // Chuỗi lưu trữ kết quả binary
        StringBuilder binaryResult = new StringBuilder();

        // Nếu số đầu vào là 0, kết quả là "0"
        if (decimalNumber.equals(BigInteger.ZERO)) {
            return "0";
        }

        // Lặp qua việc chia liên tiếp cho đến khi số chia hết
        while (!decimalNumber.equals(BigInteger.ZERO)) {
            // Lưu lại phần dư khi chia cho 2
            BigInteger remainder = decimalNumber.mod(BigInteger.valueOf(2));

            // Thêm phần dư vào đầu chuỗi kết quả
            binaryResult.insert(0, remainder);

            // Chia số cho 2 để tiếp tục vòng lặp
            decimalNumber = decimalNumber.divide(BigInteger.valueOf(2));
        }

        return binaryResult.toString();
    }

    /**
     * Cập nhật số được chuyển đổi khi số ban đầu thay đổi
     * hoặc cơ số của số ban đầu thay đổi. Sau đó in ra terminal
     * số được chuyển đổi theo định dạng a1a2...an(2).
     */
    @Override
    public void update() {
       this.originalNumber.setNumberPresentation(convertedNumber);
    }

    /**
     * Hiển thị số ra terminal theo định dạng a1a2...an(2).
     */
    @Override
    public void display() {
        System.out.println(this.originalNumber.getNumberPresentation() + "(" + this.originalNumber.getRadix() + ")");
    }
}
