package webdriver;

import org.testng.annotations.Test;

public class Topic_10_Setter_Getter {
    private String fullName;
    @Test
    public void setterGetter(){
        setFullName("Automation Testing");
        System.out.println(getFullName());

    }
    @Test
    public String getFullName(){
        return fullName;
    }
    @Test
    public void setFullName(String fullName){
        this.fullName = fullName;
    }
}
