public class Main {

    public static void main(String[] args) {

        String[][] arr = new String[][]{{"2", "5", "9", "4"}, {"2", "3", "9", "№"}, {"1", "8", "1", "6"}, {"9", "4", "2", "1"}};
        try {
            try {
                int result = method(arr);
                System.out.println(result);
            } catch (MyArraySizeException e) {
                System.out.println("Превышен размер массива!");
            }
        } catch (MyArrayDataException e) {
            System.out.println("Не корректное значение!");
            System.out.println("Ошибка в ячейке: " + e.i + "x" + e.j);
        }

    }


    public static int method(String[][] arr)
            throws MyArraySizeException, MyArrayDataException {
        int sum = 0;
        if (arr.length != 4) {
            throw new MyArraySizeException();
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != 4) {
                throw new MyArraySizeException();
            }
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    sum = sum + Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }

        }
        return sum;

    }

}
