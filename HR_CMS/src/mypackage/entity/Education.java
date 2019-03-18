package mypackage.entity;

import java.util.Date;

public class Education {
    private Date startYear;
    private Date endYear;
    private String nameOfUniversity;
    private String specialty;
    private String degreeOfEducation;
    private String experience;

    public Education(
            Date startYear,
            Date endYear,
            String nameOfUniversity,
            String specialty,
            String degreeOfEducation,
            String experience) {
        this.startYear = startYear;
        this.endYear = endYear;
        this.nameOfUniversity = nameOfUniversity;
        this.specialty = specialty;
        this.degreeOfEducation = degreeOfEducation;
        this.experience = experience;
    }

    public Education() {}

    public void eduInfo(Date startYear, Date endYear) {
        this.startYear = startYear;
        this.endYear = endYear;
        System.out.println("Education years: " + startYear.toString() + " ~ " + endYear.toString());
    }

    public Date getStartYear() { return startYear; }
    public Date getEndYear() { return endYear; }
    public String getNameOfUniversity() { return nameOfUniversity; }
    public String getSpecialty() { return specialty; }
    public String getDegreeOfEducation() { return degreeOfEducation; }
    public String getExperience() { return experience; }

}
