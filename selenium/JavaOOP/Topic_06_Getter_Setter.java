package JavaOOP;

public class Topic_06_Getter_Setter {
    //NOTE: getter, setter lien quan den tinh dong goi (encapsulation), dung de truy xuat/ cap nhat gia tri cua 1 private var
    //khi dùng getter, setter, nên khai báo biến là private
    //các variables khi dc khai báo thì chưa dc kiểm tra dữ liệu
    private String personName;
    private  int personAge;
    private int personPhone;
    private float personBankAmount;

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        if(personName==null || personName.isEmpty()){
            throw new IllegalArgumentException("Name cannot be null or empty.");
        }
        else {
            this.personName = personName;
        }
    }

    public int getPersonAge() {
        return personAge;
    }

    public void setPersonAge(int personAge) {
        if (personAge > 15 && personAge < 60){
            this.personAge = personAge;
        } else {
            throw new IllegalArgumentException("Age should be in range from 15 to 60");
        }
    }

    public int getPersonPhone() {
        return personPhone;
    }

    public void setPersonPhone(int personPhone) {
        //convert phone to string
        if (!String.valueOf(personPhone).startsWith("0")){
            throw new IllegalArgumentException("Phone is invalid.");
        } else if(personPhone < 10 || personPhone > 11) {
            throw new IllegalArgumentException("Phone should have 10-11 digits.");
        } else {
            this.personPhone = personPhone;
        }
    }

    public float getPersonBankAmount() {
        return personBankAmount;
    }

    public void setPersonBankAmount(float personBankAmount) {
        if(!(personBankAmount > 0)){
            throw new IllegalArgumentException("Bank amount should be greater than 0.");
        } else {
            this.personBankAmount = personBankAmount;
        }
    }
    public void showPersonInfo(){
        System.out.println(this.personName);
        System.out.println(this.personAge);
        System.out.println(this.personPhone);
        System.out.println(this.personBankAmount);
    }

}
