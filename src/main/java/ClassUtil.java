import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class ClassUtil {

    public void startProject() throws SQLException, Exception {
        try {
            ObjectDAO obj = new ObjectDAO();
            Parents parent1 = new Parents("Иван", "Петров", 49);
            Passport passport1 = new Passport("6403", 333234543, "Куйбышева", 57, 7);
            AreaStreet areaStreet1 = new AreaStreet("Куйбышева", "Октябрьский");
            Children child1 = new Children("Миша", "Петров", 12);
            EducateBuilding educateBuilding1 = new EducateBuilding("Школа № 23", "Первомайская", 7);
            passport1.setAreaStreet(areaStreet1);
            parent1.setPassport(passport1);
            child1.setEducateBuilding(educateBuilding1);
            Parents parent2 = new Parents("Вера", "Петровна", 47);
            Passport passport2 = new Passport("6503", 333234443, "Куйбышева", 57, 7);
            //educateBuilding1.setAreaStreet(areaStreet1);
            passport2.setAreaStreet(areaStreet1);
            parent2.setPassport(passport2);
            Set<Parents> parentsSet = new HashSet<>();
            parentsSet.add(parent1);
            parentsSet.add(parent2);
            child1.setParents(parentsSet);
            obj.save(educateBuilding1);
            obj.save(areaStreet1);
            obj.save(passport1);
            obj.save(passport2);
            obj.save(parent1);
            obj.save(parent2);
            obj.save(child1);


            Parents parent3 = new Parents("Николай", "Сергеевич", 43);
            Passport passport3 = new Passport("6573", 333124543, "Гоголя", 44, 9);
            AreaStreet areaStreet3 = new AreaStreet("Гоголя", "Октябрьский");
            passport3.setAreaStreet(areaStreet3);
            parent3.setPassport(passport3);
            Parents parent4 = new Parents("Анна", "Сергеевна", 43);
            Passport passport4 = new Passport("6023", 333124234, "Гоголя", 44, 9);
            Children child2 = new Children("Юлия", "Сергеевна", 9);
            passport4.setAreaStreet(areaStreet3);
            parent4.setPassport(passport4);
            parentsSet.clear();
            parentsSet.add(parent3);
            parentsSet.add(parent4);
            child2.setParents(parentsSet);
            child2.setEducateBuilding(educateBuilding1);
            obj.save(areaStreet3);
            obj.save(passport3);
            obj.save(passport4);
            obj.save(parent3);
            obj.save(parent4);
            obj.save(child2);

            /*educateBuilding1.setChildren(Arrays.asList(child1, child2));
            obj.save(educateBuilding1);
            Parents p = obj.findById(1);
            System.out.println("{" + p.getId() + "}{" + p.getFirst_name() + "}{" + p.getLastName() + "}{" + p.getAge() + "}");
            String nameObject = "Parents";
            String nameValue = "last_name";
            //List<Parents> list2 = obj.getObjFromTable(nameObject,nameValue, Arrays.<Object>asList(new Integer[] { 24, 27}));
            List<Parents> list2 = obj.getObjFromTable(nameObject, nameValue, Arrays.<Object>asList(new String[]{"Петров", "Петровна"}));
            System.out.println(list2);

            String objParents = "Parents";
            List<Parents> list = obj.getObjFromTable(objParents);
            System.out.println(list);
            for (Parents pAll : list) {
                System.out.println("{" + pAll.getId() + "}{" + pAll.getFirst_name() + "}{" + pAll.getLastName() + "}{" + pAll.getAge() + "}");
            }
            List<ObjectDAO> list3 = obj.getObjFromTable("Parents", "");
            obj.getObjFromTable();
            System.out.println(list3.get(1));
            System.out.println((Children) list3);*/
        }   catch (Exception e) {
                System.out.println("Ошибка работы с данных:");
            }
    }
}
