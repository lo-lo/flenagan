package exersize;

/**
 * Эта программа вычисляет простые числа, применяя алгоритм "Решето Эратосфена":
 * уберите числа, кратные меньшим простым числам, и все оставшиеся будут простыми. Она печатает
 * наибольшее число, не превосходящее аргумент, заданный в командной строке.
 **/

public class Sieve {
    public static void main(String[] args) {
        //Вычисляем все простые числа, не превосходящие заданное значение, или, если аргумент не указан,
        //все простые числа, не превосходящие 100
        int max = 100;   //присваиваем значение, принимаемое по умолчанию
        try {
            max = Integer.parseInt(args[0]);
        }  //анализируем заданный пользователем аргумент
        catch (Exception e) {
        }     //молча игнорируем исключения

        //Создаем массив, где для каждого числа указано, простое оно или нет
        boolean[] isprime = new boolean[max + 1];
        //Предполагаем, что все числа простые, пока не доказано обратное
        for (int i = 0; i <= max; i++)
            isprime[i] = true;
        //Знаем, что 0 и 1 - не простые числа
        isprime[0] = isprime[1] = false;

        //Чтобы вычислить все простые числа меньше max, нужно убрать числа, кратные всем целым, меньшим
        //чем квадратный корень из max
        int n = (int) Math.ceil(Math.sqrt(max));  // java.lang.Math
        //для каждого целого i от 0 до n: если i простое число, тогда никакое из кратных ему не простое.
        //Если i не простое число, кратные ему уже удалены, значит, этот случай пропускаем
        //
        for (int i = 0; i <= n; i++) {
            if (isprime[i])  // Если i - простое число
                for (int j = 2 * i; j <= max; j = j + i) //цикл по кратным, они не являются простыми
                    isprime[j] = false;
        }
        //Найдем наибоьшее простое
        int largest;
        for (largest = max; !isprime[largest]; largest--) ; // Пустое тело цикла
        //Выводим результат
        System.out.println("Наибольшее простое число, не превосходящее " + max + " это " + largest);
    }
}
