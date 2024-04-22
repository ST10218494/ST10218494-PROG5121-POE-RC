import static org.junit.jupiter.api.Assertions;

public class TaskTest {

    public TaskTest() {

        String[] developerName = ("Mike Smith", "Edward Harrison", "Samantha Paulson", "Glenda Oberholzer");
        String[] taskName = ("Create Login", "Create add features", "Create reports", "Add Arrays");
        int[] taskDuration = (5, 8, 2, 11);
        String[] taskStatus = ("To Do", "Doing", "Done",);
        int size = 4;

        @Test

        public void populateDeveloperArray() {

            StringBuilder printArray = new StringBuilder();

            for (int i = 0; i < size; i++) {

                printArray.append(developerName[i] + " ")
            }

            assertEquals("Mike, Smith Edward Harrison Samantha Paulson Glenda Oberholser", printArray.toString());
        }
    }
}
