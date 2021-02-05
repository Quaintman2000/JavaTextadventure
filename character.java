//package TextAdventureFiles;

public class character {
    // Prints out the set phrase like the character is talking.
    public void Talk(String stuffToSay) {
        System.out.println(GetName() + ": " + stuffToSay);
    }
    // Sets the name to whatever was passed by the parameter.
    public void SetName(String setName) {
        name = setName;
    }
    // Returns the name of the object.
    public String GetName() {
        return name;
    }
    // Stores the name.
    private String name;
}
