package netsuite.pages;


import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Login {

	WebDriver driver;
	
	public Login(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*
	 * LogOut element
	 */
	
	@FindBy(id = "signIn")
    WebElement signInButton;
	
	public String getSignInByID(){
		return "signIn";
	}
	
	public void clickSignInLink(){
		signInButton.click();
	}
	
	
	@FindBy(xpath = ".//*[@id='signOut']")
    WebElement logOutLink;
	
	public String getLogOutXpath(){
		return ".//*[@id='signOut']";
	}
	
	public void clickLogOutLink(){
		logOutLink.click();
	}
	
/*	@FindBy(id = "signOut")
    WebElement signOutButton;
	
	public String getSignOutByID(){
		return "signOut";
	}
	
	public void clickSignOutLink(){
		signOutButton.click();
	}
	*/
	
	/*
	 * Elements on Login Page (Returning customer section, Vertical line and New customer section)
	 */
	
	@FindBy(xpath = ".//*[@class='returning']")
	WebElement returningSection;
	
	public String getReturningSectionXpath(){
		return ".//*[@class='returning']";
	}
	
	@FindBy(xpath = ".//*[@class='verticalHr']")
    WebElement verticalLine;
	
	public String getVerticalLineXpath(){
		return ".//*[@class='verticalHr']";
	}
	
	@FindBy(xpath = "//*[@class='new-customer']")
    WebElement newCustomerSection;
	
	public String getNewCustomerSectionXpath(){
		return "//*[@class='new-customer']";
	}
	
	
	/*
	 * Forgot password elements
	 */
	
	@FindBy(css="a.btn.btn-link")
	WebElement forgotPasswordLink;
	
	public void clickForgotPasswordLink(){
		forgotPasswordLink.click();
	}
	
	
	@FindBy(id= "email")
	WebElement emailFieldForForgotPassword;
	
	public void setEmailInForgotPasswordField(String email){
		emailFieldForForgotPassword.clear();
		emailFieldForForgotPassword.sendKeys(email);
	}
	
	public String getEmailFieldForgotPasswordXpath(){
		return ".//*[@id='email']";
	}

	
	@FindBy (xpath = "//button[@type='submit']")
    WebElement submitForForgotPassword;
	
	public void submitForgotPasword(){
		submitForForgotPassword.click();
	}
	
	
    @FindBy (css = "div.alert.alert-success")
    WebElement forgotPasswordSuccessMessage;
    
    public String getForgotPasswordSuccessMessage(){
    	return forgotPasswordSuccessMessage.getText();
    }
    
    public String getForgotPasswordSuccessMessageCss(){
		return "div.alert.alert-success";
	}
    
    
    @FindBy (css = "div.alert.alert-error")
    WebElement forgotPasswordErrorMessage;
    
    
    public String getForgotPasswordErrorMessage(){
    	return forgotPasswordErrorMessage.getText();
    }
    
    public String getForgotPasswordErrorMessageCss(){
		return "div.alert.alert-error";
	}
    
    
    
    
    
    /*
     *  RETURNING CUSTOMER SECTION
     */
    
    @FindBy(id = "login-email")
    WebElement emailFieldForReturnCustomer; 

    public void setEmailForReturningCustomer(String email){
    	emailFieldForReturnCustomer.clear();
    	emailFieldForReturnCustomer.sendKeys(email);
    }
    
    @FindBy(id = "login-password")
    WebElement passwordFieldForReturnCustomer;
    
    public void setPasswordForReturningCustomer(String password){
    	passwordFieldForReturnCustomer.clear();
    	passwordFieldForReturnCustomer.sendKeys(password);
    }
    
    @FindBy(id = "login")
    WebElement submitButtonForReturnCustomer;
    
    public void clickSubmitButtonForReturnCustomer(){
    	submitButtonForReturnCustomer.click();
    }
	
    public void loginAsReturningCustomer(String email,String password){
		setEmailForReturningCustomer(email);
		setPasswordForReturningCustomer(password);
		clickSubmitButtonForReturnCustomer();	
	}
    
    /* 
     * NEW CUSTOMER SECTION
     */
	
    //Fields for fill in New Customer
    String randomNumbers = RandomStringUtils.randomNumeric(9);
    String emailForNewIndUser = "PoppinQA" + randomNumbers + "@gmail.com";
    
    public String getRandomEmailForNewInduvidualCustomer(){
    	return emailForNewIndUser;
    }
    
    String emailForNewBusUser = "PoppinQA" + randomNumbers + "@gmail.com";
    
    public String getRandomEmailForNewBusinessCustomer(){
    	return emailForNewBusUser;
    }
    
    String companyForNewUser = "Autocompany" + randomNumbers; 
    
    public String getRandomCompanyForNewBusinessCustomer(){
    	return companyForNewUser;
    }
    
    
    //Describe all fields on New customer section
    @FindBy(id = "register-firstname")
    WebElement firstNameFieldForNewCustomer;
    
    public void setFirstNameForNewCustomer(String firstName) {
    	firstNameFieldForNewCustomer.sendKeys(firstName);
    }

    @FindBy(id = "register-lastname")
    WebElement lastNameFieldForNewCustomer;
    
    public void setLastNameForNewCustomer(String lastName) {
    	lastNameFieldForNewCustomer.sendKeys(lastName);
    }

    @FindBy(id = "register-email")
    WebElement emailFieldForNewCustomer;
   
    public void setEmailForNewCustomer(String emailForNewIndUser) {
    	emailFieldForNewCustomer.sendKeys(emailForNewIndUser);
    }
    
    @FindBy(id = "register-password")
    WebElement passwordFieldForNewCustomer;

    public void setPasswordForNewCustomer(String password) {
    	passwordFieldForNewCustomer.sendKeys(password);
    }
    

    
    @FindBy(id = "register-company")
    WebElement companyFieldForNewCustomer;
    
    public void setCompanyForNewCustomer(String companyForNewUser) {
    	companyFieldForNewCustomer.sendKeys(companyForNewUser);
    }

    @FindBy(id = "register-emailsubscribe")
    WebElement signUpForNewslettersCheckbox;
    
    public void clickSubscribeCheckbox(){
    	signUpForNewslettersCheckbox.click();
    }

    @FindBy(id = "submit")
    WebElement submitButtonForNewCustomer;
    
    public void clickSubmitButtonForNewCustomer(){
    	submitButtonForNewCustomer.click();
    }
    
    @FindBy(id = "myself_radio")
    WebElement mySelfRadioButton;
    
    public void clickForMySelfRadioButton(){
    	mySelfRadioButton.click();
    }
    
    @FindBy(id = "business_radio")
    WebElement businessRadioButton;
    
    public void clickForBusinessRadioButton(){
    	businessRadioButton.click();
    }
    
   
    //Create new INDIVIDUAL customer
    public void createNewIndividualCustomer(String firstName, String lastName, String emailForNewIndUser, String password){
    	setFirstNameForNewCustomer(firstName);
    	setLastNameForNewCustomer(lastName);
    	setEmailForNewCustomer(emailForNewIndUser);
    	setPasswordForNewCustomer(password);
    	clickSubmitButtonForNewCustomer();
    }
    
    //Create new BUSINESS customer
    public void createNewBusinessCustomer(String firstName, String lastName, String emailForNewIndUser, String password, String companyForNewUser){
    	setFirstNameForNewCustomer(firstName);
    	setLastNameForNewCustomer(lastName);
    	setEmailForNewCustomer(emailForNewIndUser);
    	setPasswordForNewCustomer(password);
    	setCompanyForNewCustomer(companyForNewUser);
    	clickSubmitButtonForNewCustomer();
    }   
    
    //Create new customer that Shopping for mySelf
    public void createNewCustomerShoppingForMyself(String firstName, String lastName, String emailForNewIndUser, String password){
    	setFirstNameForNewCustomer(firstName);
    	setLastNameForNewCustomer(lastName);
    	setEmailForNewCustomer(emailForNewIndUser);
    	setPasswordForNewCustomer(password);
    	clickForMySelfRadioButton();
    	clickSubmitButtonForNewCustomer();
    }    
    
    //Create new customer that Shopping for Business
    public void createNewCustomerShoppingForBusiness(String firstName, String lastName, String emailForNewIndUser, String password){
    	setFirstNameForNewCustomer(firstName);
    	setLastNameForNewCustomer(lastName);
    	setEmailForNewCustomer(emailForNewIndUser);
    	setPasswordForNewCustomer(password);
    	clickForBusinessRadioButton();
    	clickSubmitButtonForNewCustomer();
    }
    
    /* 
     * Error messages
     */
    
    //Get error message for New customer
    @FindBy(css = "div.alert.alert-error")
    WebElement errorMessageMain;
    
    public String getMainErrorMessage_NewCustomer(){
    	return errorMessageMain.getText();
    }    
        
/*    public String getMainErrorMessage_NewCustomer(){
    	String error = errorMessageMain.getText();
    	error = error.replace(oldChar, newChar)
    }    
    */
    
    
    @FindBy(xpath = "//div[@id='register-view']/form/div[2]/div/p")
    WebElement errorMessageFirstName;
    
    public String getErrorMessageTextForFirstNameField_NewCustomer(){
    	return errorMessageFirstName.getText();
    }

    @FindBy(xpath = "//div[@id='register-view']/form/div[3]/div/p")
    WebElement errorMessageLastName;

    public String getErrorMessageTextForLastNameField_NewCustomer(){
    	return errorMessageLastName.getText();
    }
    
    @FindBy(xpath = "//div[@id='register-view']/form/div[5]/div/span")
    WebElement errorMessageEmailNewCustomer;
    
    public String getErrorMessageTextForEmailField_NewCustomer(){
    	return errorMessageEmailNewCustomer.getText();
    }
    
    public String getErrorMessageForEmailFieldXpath_NewCustomer(){
    	return "//div[@id='register-view']/form/div[5]/div/span";
    }
    
    @FindBy(xpath = "//div[@id='register-view']/form/div[6]/div/p")
    WebElement errorMessagePasswordNewCustomer;
    
    public String getErrorMessageTextForPasswordField_NewCustomer(){
    	return errorMessagePasswordNewCustomer.getText();
    }
    
    @FindBy(xpath = "//div[@id='register-view']/form/div[7]/div/p")
    WebElement errorMessagePasswordConfirmNewCustomer;
    
    public String getErrorMessageTextForPasswordConfirmField_NewCustomer(){
    	return errorMessagePasswordConfirmNewCustomer.getText();
    }    
    
    //Get error message for Returning customer 
    @FindBy(xpath = ".//*[@id='powerTipPassword']/p")
    WebElement passwordErrorMessage;
    
    public String getErrorMessageTextForPasswordField_ReturningCustomer(){
    	return passwordErrorMessage.getText();
    }

    @FindBy(xpath = ".//*[@id='powerTipEmaillog']/p")
    WebElement emailErrorMessage;
    
    public String getErrorMessageTextForEmailField_ReturningCustomer(){
    	return emailErrorMessage.getText();
    }
}
