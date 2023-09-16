package com.gopal.fast.vid.NewImplement.model;

public enum EPFService {
    epf1("➺ Ways to Check EPF Balance Online \n\n➺The EPFO has been introducing new methods for employees to check the EPF balance and is in the process of developing the existing platforms that can be used. \n\n➺ Online Portal \n\n➺ SMS Service \n\n➺ Missed Call."),
    epf2("➺ EPFO introduced a new system to facilitate online submission of transfer claims by Members with an objective to make the transfer process transparent, efficient and comfortable for your employees. \n\n➺ You are urged to bring this facility to the notice of all your employees which is available on EPFOs Member portal. \n\n➺ A member has an option to submit his claim either through his present employer or the previous one. \n\n➺ You can see all such claim requests with ease, verify/correct member details, approve and submit the requests online through this portal. \n\n➺ For online submission of the claims, the Digital signature (Class II or above) of the authorized person is required."),
    epf3("➺ Visit the EPF Portal and click on ‘Our Services’ on the dashboard and click on For Employees. \n\n➺ Click on Member Passbook \n\n➺ The following details must be populated to log in to access the account."),
    epf4("➺ EPFO Recruitment 2019 Free Job alert for both Fresher and Experienced Candidates updated on March 12, 2019. \n\n➺ Get Direct Official Link for applying EPFO Recruitment 2019 along with current EPFO Recruitment official Notification 2019 here. \n\n➺ Find all recent EPFO Vacancy 2019 across India and check all latest EPFO 2019 job openings instantly here, Know upcoming EPFO Recruitment 2019 immediately here."),
    epf5("➺ View all Tender Notifications issued by Employees Provident Fund Organisation. \n\n➺ Search live eProcurement business opportunities available in EPFO Tenders section. \n\n➺ Employees Provident Fund Organisation Tenders are further filtered by Bid Submission Date, Tender Value, Project Location and Product Category. \n\n➺Get email alert on Tenders from Employees Provident Fund Organisation - (EPFO)."),
    epf6("➺ View all Tender Notifications issued by Employees Provident Fund Organisation. \n\n➺ Search live eProcurement business opportunities available in EPFO Tenders section. \n\n➺Employees Provident Fund Organisation Tenders are further filtered by Bid Submission Date, Tender Value, Project Location and Product Category. \n\n➺ Get email alert on Tenders from Employees Provident Fund Organisation - (EPFO).");

    public String description;

    EPFService(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
