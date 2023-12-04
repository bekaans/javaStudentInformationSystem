public class Student {
    String name,stuNo;
    int classes;
    Course mat;
    Course fizik;
    Course kimya;
    double avarage;
    Course fiziksozlu;
    boolean isPass;



    Student(String name, int classes, String stuNo, Course mat,Course fizik,Course kimya,Course fiziksozlu) {
        this.name = name;
        this.classes = classes;
        this.stuNo = stuNo;
        this.mat = mat;
        this.fizik = fizik;
        this.kimya = kimya;
        this.fiziksozlu=fiziksozlu;
        this.isPass = false;
        calcAvarage();
    }


    public void addBulkExamNote(int mat, int fizik, int kimya,int fiziksozlu) {

        if (mat >= 0 && mat <= 100) {
            this.mat.note = mat;
        }

        if (fizik >= 0 && fizik <= 100) {
            this.fizik.note = fizik;
        }

        if (kimya >= 0 && kimya <= 100) {
            this.kimya.note = kimya;

        }
        if (fiziksozlu >= 0 && fiziksozlu <= 100) {
            this.fiziksozlu.note = fiziksozlu;
        }
    }

    public void isPass() {
        if (this.mat.note == 0 || this.fizik.note == 0 || this.kimya.note == 0) {
            System.out.println("Notlar tam olarak girilmemiş");
        } else {
            this.isPass = isCheckPass();
            printNote();
            System.out.println("Ortalama : " + this.avarage);
            if (this.isPass) {
                System.out.println("Sınıfı Geçti. ");
            } else {
                System.out.println("Sınıfta Kaldı.");
            }
        }
    }

    public void calcAvarage() {
        this.avarage = ((this.fizik.note*0.80 + this.fiziksozlu.note*0.20) + this.kimya.note + this.mat.note) / 3;
    }


    public boolean isCheckPass() {
        calcAvarage();
        return this.avarage > 55;
    }

    public void printNote(){
        System.out.println("=========================");
        System.out.println("Öğrenci : " + this.name);
        System.out.println("Matematik Notu : " + this.mat.note);
        System.out.println("Fizik Notu : " + this.fizik.note);
        System.out.println("Fizik Sözlü Notu :"+this.fiziksozlu.note);
        System.out.println("Kimya Notu : " + this.kimya.note);
    }

}