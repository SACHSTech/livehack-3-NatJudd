class Problem1 extends ConsoleProgram {

  /**
   * makes a username for the user and checks if the user's password is valid
   * 
   * @author NJudd
   */

  public void run() {
    // heading
    System.out.println("***** Student Account Registration *****");
    // receives user input
    String strFirstName = readLine("Enter your first name: ");
    String strLastName = readLine("Enter your last name: ");
    String strStudentNum = readLine("Enter your student number: ");
    String strPassword = readLine("Enter a new password: ");
    // calls methods and receives values
    String strUsername = createUserName(strFirstName, strLastName, strStudentNum);
    boolean blnValidPassword = validatePassword(strPassword);
    // new line
    System.out.println(" ");
    // prints output
    System.out.println("Your username is: " + strUsername);
    System.out.println("Valid password: " + blnValidPassword);
  }

  /**
   * creates a username for the user
   * 
   * @param strFirstN user's first name
   * @param strLastN  user's last name
   * @param strStuNum user's student number
   * @return user's username
   * 
   * @author Njudd
   */
  private String createUserName(String strFirstN, String strLastN, String strStuNum) {
    // initializes string type variables
    String strUsername = "";
    String strLastInitial = "";
    String strNumDigits = "";
    // calculates the user's first name initial
    char charFirstInitial = strFirstN.charAt(0);
    charFirstInitial = Character.toUpperCase(charFirstInitial);
    // calculates last 4 characters of the user's last name
    for (int i = 0; i < 4; i++) {
      char charLastInitial = strLastN.charAt(i);
      charLastInitial = Character.toLowerCase(charLastInitial);
      strLastInitial += charLastInitial;
    }
    // calculates the last 3 digits of the user's student number
    for (int i = 0; i < 3; i++) {
      char studentNum = strStuNum.charAt(6 + i);
      strNumDigits += studentNum;
    }
    // calculates the final username
    strUsername = charFirstInitial + strLastInitial + strNumDigits;
    // returns the username
    return strUsername;
  }

  /**
   * returns true if password is valid, else returns false
   * 
   * @param strPassword the password being checked if valid or not
   * @return the value (true or false) of the passwords validation
   * 
   * @author Njudd
   */
  private boolean validatePassword(String strPassword) {
    // initializes variables
    boolean blnValid = true;
    String strValidChar = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz1234567890";
    int intLength = strPassword.length();
    char ch1;
    String strUppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    // checks if a character is uppercase
    for (int i = 0; i < intLength; i++) {
      ch1 = strPassword.charAt(i);
      if (strUppercase.indexOf(ch1) >= 0) {
        blnValid = true;
        break;
      } else {
        blnValid = false;
      }
    }
    // checks if password is only letters or digits
    for (int i = 0; i < intLength; i++) {
      ch1 = strPassword.charAt(i);
      // letters or digits
      if (strValidChar.indexOf(ch1) < 0) {
        blnValid = false;
      }
    }
    // checks if password is 7 characters long
    if (intLength < 7) {
      blnValid = false;
    }
    // returns if the password is valid
    return blnValid;
  }
}