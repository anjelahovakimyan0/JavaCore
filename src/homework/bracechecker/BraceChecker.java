package homework.bracechecker;

public class BraceChecker {

    private String text;
    private Stack stck = new Stack(10);
    int pop;

    public BraceChecker(String text) {
        this.text = text;
    }

    public void check() {
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            switch (c) {
                case '(':
                case '{':
                case '[':
                    stck.push(c);
                    break;
                case ')':
                    pop = stck.pop();
                    if (pop == 0) {
                        System.out.println("Error: Closed " + c + ", but not opened at " + i);
                    } else if (pop != '(') {
                        System.out.println("Error: Opened " + (char) pop + ", but closed " + c + " at " + i);
                    }
                    break;
                case '}':
                    pop = stck.pop();
                    if (pop == 0) {
                        System.out.println("Error: Closed " + c + ", but not opened at " + i);
                    } else if (pop != '{') {
                        System.out.println("Error: Opened " + (char) pop + ", but closed " + c + " at " + i);
                    }
                    break;
                case ']':
                    pop = stck.pop();
                    if (pop == 0) {
                        System.out.println("Error: Closed " + c + ", but not opened at " + i);
                    } else if (pop != '[') {
                        System.out.println("Error: Opened " + (char) pop + ", but closed " + c + " at " + i);
                    }
                    break;

            }
        }
        while (stck.getSize() >= 0) {
            System.out.println("Error: Opened " + (char) stck.pop() + " but not closed.");
        }
    }
}
