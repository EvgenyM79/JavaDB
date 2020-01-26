import java.sql.SQLException;
import java.util.*;

public class ClassUtil {

    public void startProject() throws SQLException, Exception {
        try {
            ObjectDAO obj = new ObjectDAO();
            /*Parents parent1 = new Parents("Иван", "Петров", 36);
            AreaStreet areaStreet = new AreaStreet("Куйбышева", "Октябрьский");
            Passport passport1 = new Passport("6403", 333234543, "Куйбышева", 57, 7, areaStreet);
            AreaStreet areaStreet2 = new AreaStreet("Первомайская", "Октябрьский");
            Children child1 = new Children("Миша", "Петров", 5);
            EducateBuilding educateBuilding1 = new EducateBuilding("Школа № 23", "Первомайская", 7, areaStreet2);
            AreaStreet areaStreet3 = new AreaStreet("Ленина", "Центральный");
            Children child2 = new Children("Анна", "Петровна", 2);
            EducateBuilding educateBuilding2 = new EducateBuilding("Школа № 12", "Ленина", 15, areaStreet3);
            parent1.setPassport(passport1);
            child1.setEducateBuilding(educateBuilding1);
            child2.setEducateBuilding(educateBuilding2);
            Parents parent2 = new Parents("Вера", "Петровна", 30);
            Passport passport2 = new Passport("6503", 333234443, "Куйбышева", 57, 7,areaStreet);
            parent2.setPassport(passport2);
            List<Parents> parentsList = new ArrayList<>();
            parentsList.add(parent1);
            parentsList.add(parent2);
            child1.setParents(parentsList);
            child2.setParents(parentsList);
            obj.save(educateBuilding1);
            obj.save(educateBuilding2);
            obj.save(passport1);
            obj.save(passport2);
            obj.save(parent1);
            obj.save(parent2);
            obj.save(child1);
            obj.save(child2);


            Parents parent3 = new Parents("Николай", "Сергеевич", 32);
            areaStreet = new AreaStreet("Гоголя", "Октябрьский");
            Passport passport3 = new Passport("6573", 333124543, "Гоголя", 44, 9,areaStreet);
            parent3.setPassport(passport3);
            Parents parent4 = new Parents("Анна", "Сергеевна", 27);
            Passport passport4 = new Passport("6023", 333124234, "Гоголя", 44, 9,areaStreet);
            Children child3 = new Children("Юлия", "Сергеевна", 4);
            parent4.setPassport(passport4);
            parentsList.clear();
            parentsList.add(parent3);
            parentsList.add(parent4);
            child3.setParents(parentsList);
            child3.setEducateBuilding(educateBuilding1);
            obj.save(passport3);
            obj.save(passport4);
            obj.save(parent3);
            obj.save(parent4);
            obj.save(child3);*/

 //Вывод всех людей
            String objParents = "Parents";
            List<Parents> list = obj.getObjFromTable(objParents);
            System.out.println(list + "\n");

 //Вывод всех параметров по одному человеку
            Parents p = obj.findByIdParent(1);
            Passport pt = p.getPassport();
            System.out.println(p);
            System.out.println(pt);
            List <Children> c = p.getChildren();
            for (Children ch: c){
                EducateBuilding e = ch.getEducateBuilding();
                System.out.println(ch);
                System.out.println(e);
            }
            System.out.println("\n");


            //Вывод всех параметров по одному ребенку
            System.out.println("dfdf");
            Children ch = obj.findByIdChild(3);
            EducateBuilding eb = obj.findByIdEducation(ch.getEb_id());
            System.out.println(ch);
            System.out.println(eb + "\n");
            System.out.println(eb.getAreaStreet().getAs_area());

            //Вывод всех параметров по школам в одном районе
            List<EducateBuilding> listEducation = obj.getObjFromTable("ebuilding", String.valueOf(eb.getAreaStreet().getAs_area()));
            System.out.println(listEducation);




            /*// Реализация функции с забором всех обьектов с набором фамилий или с набором возрастов
            String nameObject = "Parents";
            String nameValue = "last_name";
            //List<Parents> list2 = obj.getObjFromTable(nameObject,nameValue, Arrays.<Object>asList(new Integer[] { 27, 32}));
            List<Parents> list3 = obj.getObjFromTable(nameObject, nameValue, Arrays.<Object>asList(new String[]{"Петров", "Петровна", "Сергеевич"}));
            //System.out.println("Вывести всех у кого возраст 27 или 32 года\n" + list2);
            System.out.println("Вывести всех людей у кого ФИО: \"Петров\", \"Петровна\", \"Сергеевич\"\n" + list3);
*/
            //List<ObjectDAO> list3 = obj.getObjFromTable("Parents", "");
            //obj.getObjFromTable();
            //System.out.println(list3.get(1));
            //System.out.println(list3);*/
        } catch (Exception e) {
            System.out.println("Ошибка работы с данных:");
        }
    }
}
