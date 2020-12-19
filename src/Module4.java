import java.util.ArrayList;
import java.util.Scanner;

public class Module4 {
    public static void main(String[] args) {
        System.out.println("TASK 1");
        Task1();
        System.out.println("TASK 2");
        Task2();
        System.out.println("TASK 3");
        Task3();
        System.out.println("TASK 4");
        Task4();
        System.out.println("TASK 5");
        Task5();
        System.out.println("TASK 6");
        Task6();
        System.out.println("TASK 7");
        Task7();
        System.out.println("TASK 8");
        Task8();
        System.out.println("TASK 9");
        Task9();
        System.out.println("TASK 10");
        Task10();
    }
    public static void Task1(){
        Scanner scanstr = new Scanner(System.in);
        System.out.println("Enter string: ");
        String string = scanstr.nextLine();
        System.out.println("Enter n: ");
        int n = scanstr.nextInt();
        System.out.println("Enter k: ");
        int k = scanstr.nextInt();
        System.out.println(BessiesEssay(n, k, string));
    }

    public static String BessiesEssay(int n, int k, String str){
       int r = 0;
       String[] wordArray = str.split(" ");
       String result = "";
       str = "";
       for (int i = 0; i < n; i++){
           if( str.length() + wordArray[i].length() > k){
               result = result.trim() + "\r\n" + wordArray[i] + " ";
               str = wordArray[i];
           } else{
               result = result + wordArray[i] + " ";
               str = str + wordArray[i];
           }
       }
       return result.trim();
    }
    public static void Task2(){
        Scanner scanstr = new Scanner(System.in);
        System.out.println("Enter string: ");
        String str = scanstr.nextLine();
        System.out.println("Result is:"  + split(str));
    }
    public static String split(String s){
        String resS = "";
        ArrayList<String> listS = new ArrayList<String>();
        int counter = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                counter++;
            else
                counter--;
            resS += s.charAt(i);
            if (counter == 0) {
                listS.add(resS);
                resS = "";
            }
        }
        return listS.toString();
    }

    public static void Task3(){
        Scanner scanstr = new Scanner(System.in);
        System.out.println("Enter string in snake_case: ");
        String strS = scanstr.nextLine();
        System.out.println("Enter string in camelCase: ");
        String strC = scanstr.nextLine();
        System.out.println("Result in snake_case:" + toSnakeCase(strC));
        System.out.println("Result in camelCase:"  + toCamelCase(strS));
    }

    public static String toSnakeCase(String str){
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isUpperCase(ch)) {
                result = result + '_';
                result= result + Character.toLowerCase(ch);
            }
            else {
                result = result + ch;
            }
        }

        return result;
    }

    public static String toCamelCase(String str){
        StringBuilder builder = new StringBuilder(str);
        for (int i = 0; i < builder.length(); i++) {
            if (builder.charAt(i) == '_') {
                builder.deleteCharAt(i);
                builder.replace(i, i + 1, String.valueOf(Character.toUpperCase(builder.charAt(i))));
            }
        }
        return builder.toString();
    }

    public static void Task4() {
        Scanner scanstr = new Scanner(System.in);
        System.out.println("Enter: ");
        String s = scanstr.nextLine();
        System.out.println("Result: ");
        System.out.println("$"+ String.format("%.2f",overTime(s)));
    }

    public static double overTime(String s){
        String [] arrS = s.split(" ");
        double [] sDouble = new double[arrS.length];
        double sum = 0;
        for (int i = 0; i < arrS.length; i++)
            sDouble[i] = Double.parseDouble(arrS[i]);
        if (sDouble[1] <=17)
            sum = (sDouble[1] - sDouble[0])*sDouble[2];
        else
            sum = (sDouble[1] - 17)*sDouble[2]*sDouble[3] + (17 - sDouble[0])*sDouble[2];
        return sum;
    }

    public static void Task5(){
        Scanner scanstr = new Scanner(System.in);
        System.out.println("Enter the weight");
        String weight = scanstr.nextLine();
        System.out.println("Enter the height");
        String height = scanstr.nextLine();
        System.out.println("Result: ");
        System.out.println(bmi(weight, height));
    }

    public static String bmi(String weight, String height){
        double weightD = Double.parseDouble(weight.split(" ")[0]);
        double heightD = Double.parseDouble(height.split(" ")[0]);
        String res = "";
        if (weight.contains("pounds"))
            weightD *= 0.45;
        if (height.contains("inches"))
            heightD *= 0.0254;
        double bmi = Math.round((weightD / (heightD * heightD)) * 10.0) / 10.0;
        if (bmi < 18.5)
            bmi = Math.ceil(bmi);
            res = bmi + " Underweight";
        if (bmi >= 18.5 && bmi <= 24.9)
            bmi = Math.ceil(bmi);
            res = bmi + " Normal weight";
        if (bmi > 25)
            bmi = Math.ceil(bmi);
            res = bmi + " Overweight";
        return res;
    }

    public static void Task6(){
        Scanner scanstr = new Scanner(System.in);
        System.out.println("Enter the number");
        int num = scanstr.nextInt();
        System.out.println("Result: ");
        System.out.println(bugger(num));
    }

    public static int bugger(int n) {
        int c = 0;
        while (n > 9) {
            int ch = 1;
            while (n > 0) {
                ch *= n % 10;
                n /= 10;
            }
            n = ch;
            c++;
        }
        return c;
    }

    public static void Task7(){
        Scanner scanstr = new Scanner(System.in);
        System.out.println("Enter the string"); // Ввод s
        String s = scanstr.nextLine();
        System.out.println("Result: ");
        System.out.println(toStarShorthand(s));
    }

    public static String toStarShorthand(String s) {
        int count = 1;
        char l = s.charAt(0);
        String newStr = "";
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != l) {
                if (count != 1)
                    newStr += l + "*" + count;
                else
                    newStr += l;
                l = s.charAt(i);
                count = 1;
            } else
                count++;
        }
        if (count != 1)
            newStr += l + "*" + count;
        else
            newStr += l;
        return newStr;
    }

    public static void Task8(){
        Scanner scanstr = new Scanner(System.in);
        System.out.println("Enter the first string: ");
        String s = scanstr.nextLine();
        System.out.println("Enter the second string: ");
        String s1 = scanstr.nextLine();
        System.out.println("Result: " + doesRhyme(s,s1));
    }

    public static boolean doesRhyme(String s1, String s2){
        s1 = s1.substring(s1.lastIndexOf(" ") + 1).toLowerCase();
        s2 = s2.substring(s2.lastIndexOf(" ") + 1).toLowerCase();
        String let = "aeiouy";
        String res1 = "", res2 = "";
        for (int i = 0; i < s1.length(); i++) {
            if (let.indexOf(s1.charAt(i)) != -1)
                res1 += s1.charAt(i);
        }
        for (int i = 0; i < s2.length(); i++) {
            if (let.indexOf(s2.charAt(i)) != -1)
                res2 += s2.charAt(i);
        }
        return res1.equals(res2);
    }

    public static void Task9(){
        Scanner scanstr = new Scanner(System.in);
        System.out.println("Enter the first number");
        String num1 = scanstr.nextLine();
        System.out.println("Enter the second number");
        String num2 = scanstr.nextLine();
        System.out.println("Result: ");
        System.out.println(trouble(num1,num2));
    }

    public static boolean trouble(String num1, String num2){
        int sym = 0;
        for (int i = 2; i < num1.length(); i++) {
            if (num1.charAt(i) == num1.charAt(i - 1) && num1.charAt(i) == num1.charAt(i - 2))
                sym = num1.charAt(i);
        }
        for (int i = 0; i < num2.length(); i++) {
            if (num2.charAt(i) == sym && num2.charAt(i + 1) == sym)
                return true;
        }
        return false;
    }

    public static void Task10(){
        Scanner scanstr = new Scanner(System.in);
        System.out.println("Enter the stringSequence"); // Ввод s
        String s = scanstr.nextLine();
        System.out.println("Enter the bookEnd"); // Ввод s
        String ch = scanstr.nextLine();
        System.out.println("Result: ");
        System.out.println(countUniqueBooks(s,ch));

    }

    public static int countUniqueBooks(String s, String ch){
        String new_s = "";
        int counter = 0;
        int index = 0;
        for (int i = 0; i<s.length(); i++)
            if (s.charAt(i) == ch.charAt(0))
                counter++;
        for (int i = 0; i<counter/2; i++) {
            index = s.indexOf(ch, index);
            int nextIndex = s.indexOf(ch, index + 1);
            new_s += s.substring(index+1, nextIndex);
            index = s.indexOf(ch, nextIndex + 1);
        }
        counter = 0;
        boolean[] isItThere = new boolean[Character.MAX_VALUE];
        for (int i = 0; i < new_s.length(); i++) {
            isItThere[new_s.charAt(i)] = true;
        }
        for (int i = 0; i < isItThere.length; i++) {
            if (isItThere[i]){
                counter++;
            }
        }
        return counter;
    }
}
