package mypackage.entity;

public class Education {
    private int startYear;
    private int endYear;
    private String nameOfUniversity;
    private String specialty;
    private String degreeOfEducation;

    public Education(
            int startYear,
            int endYear,
            String nameOfUniversity,
            String specialty,
            String degreeOfEducation) {
        this.startYear = startYear;
        this.endYear = endYear;
        this.nameOfUniversity = nameOfUniversity;
        this.specialty = specialty;
        this.degreeOfEducation = degreeOfEducation;
    }

    public void eduInfo(int startYear, int endYear) {
        this.startYear = startYear;
        this.endYear = endYear;
        System.out.println("Education years: " + startYear + " ~ " + endYear);
    }

    @Override
    public String toString() {

        String result = this.getStartYear() != 0 ? this.getStartYear() + " " : "";
        result += this.getEndYear() != 0 ? this.getEndYear() + " " : " ";
        result += this.getNameOfUniversity() != null ? this.getNameOfUniversity() + " " : " ";
        result += this.getSpecialty() != null ? this.getSpecialty() + " " : " ";
        result += this.getDegreeOfEducation() != null ? this.getDegreeOfEducation() + " " : " ";

        return result;
    }

    public int getStartYear() { return startYear; }
    public int getEndYear() { return endYear; }
    public String getNameOfUniversity() { return nameOfUniversity; }
    public String getSpecialty() { return specialty; }
    public String getDegreeOfEducation() { return degreeOfEducation; }

}
