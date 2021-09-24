import java.util.ArrayList;

public class WordGenerator {

    public void generatePossibleWords(int phoneNumber) {
        String[][] letterArray = new String[][]{
                {"0"},
                {"1"},
                {"A", "B", "C"},
                {"D", "E", "F"},
                {"G", "H", "I"},
                {"J", "K", "L"},
                {"M", "N", "O"},
                {"P", "Q", "R", "S"},
                {"T", "U", "V"},
                {"W", "X", "Y", "Z"}};


        ArrayList<String[]> workingArray = new ArrayList<>();
        while (phoneNumber > 0) {
            int digit = phoneNumber % 10;
            workingArray.add(letterArray[digit]);
            phoneNumber = phoneNumber / 10;
        }

        print(workingArray);
        System.out.println("Finish");

    }

    private void print(ArrayList<String[]> workingArray) {

        // array for indexes
        int n = workingArray.size();
        int[] indexes = new int[n];

        // initializing indexes
        for (int i = 0; i < n; i++) {
            indexes[i] = 0;
        }

        while (true) {
            // printing current combinations
            for (int i = n - 1; i >= 0; i--) {
                System.out.print(workingArray.get(i)[indexes[i]]);
            }
            System.out.println();

            // find array which has the most elements after current element
            int next = n - 1;
            while (next >= 0 && (indexes[next] + 1 >= workingArray.get(next).length)) {
                next--;
            }

            // if there is no such an array, you've checked all the arrays
            if (next < 0) {
                return;
            }

            // if found move to next element of that array
            indexes[next]++;

            // index to fisrt element
            for (int i = next + 1; i < n; i++) {
                indexes[i] = 0;
            }
        }

    }
}
