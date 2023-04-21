package org.example;

import java.util.Objects;

    /**Класс Worker представляет работника со следующими характеристиками:
        Идентификационный номер (IDNP), имя, фамилию, должность, категорию зарплаты и опыт работы.*/
public class Worker {
    /**
     Вложенный класс, который используется для создания "пустого" работника.
     */
    private static class EmptyWorker {
        public static final Worker emptyWorker = new Worker();
    }

    private final long idnp; // Идентификационный номер работника

    private final String nameEmploy;  // Имя работника

    private final String surnameEmploy;  // Фамилия работника

    private final String positionEmploy;  // Должность работника

    private final String salaryCategory;  // Категория зарплаты работника

    private final Integer experienceEmploy;  // Опыт работы работника
    /**
     Конструктор, создающий нового работника с заданными характеристиками.
     @param idnp Идентификационный номер работника
     @param nameEmploy Имя работника
     @param surnameEmploy Фамилия работника
     @param positionEmploy Должность работника
     @param salaryCategory Категория зарплаты работника
     @param experienceEmploy Опыт работы работника
     */
    public Worker(long idnp,
                  String nameEmploy,
                  String surnameEmploy,
                  String positionEmploy,
                  String salaryCategory,
                  Integer experienceEmploy) {
        this.idnp = idnp;
        this.nameEmploy = nameEmploy;
        this.surnameEmploy = surnameEmploy;
        this.positionEmploy = positionEmploy;
        this.salaryCategory = salaryCategory;
        this.experienceEmploy = experienceEmploy;
    }
    /**
     Конструктор, создающий нового работника на основе другого работника.
     @param worker Работник, на основе которого создается новый работник
     */
    public Worker(Worker worker) {
        this.idnp = worker.getIdnp();
        this.nameEmploy = worker.getNameEmploy();
        this.surnameEmploy = worker.getSurnameEmploy();
        this.positionEmploy = worker.getPositionEmploy();
        this.salaryCategory = worker.getSalaryCategory();
        this.experienceEmploy = worker.getExperienceEmploy();
    }
    /**
     Приватный конструктор, создающий "пустого" работника.
     Используется внутри класса для создания статической константы "emptyWorker".
     */
    private Worker() {
        this.idnp = 0;
        this.nameEmploy = "Tonya";
        this.surnameEmploy = "Melnyk";
        this.positionEmploy = "Designer";
        this.salaryCategory = "S";
        this.experienceEmploy = 0;
    }

    /**    Метод emptyWorker возвращает экземпляр класса Worker, который является пустым (не содержит никакой информации).*/
    public static Worker emptyWorker() {
        return EmptyWorker.emptyWorker;
    }

    /**    Метод getIdnp возвращает ИДНП работника.*/
    public long getIdnp() {
        return idnp;
    }

    /**    Метод getNameEmploy возвращает имя работника.*/
    public String getNameEmploy() {
        return nameEmploy;
    }

    /**    Метод getSurnameEmploy возвращает фамилию работника.*/
    public String getSurnameEmploy() {
        return surnameEmploy;
    }

    /**    Метод getPositionEmploy возвращает должность работника.*/
    public String getPositionEmploy() {
        return positionEmploy;
    }
    /**    Метод getSalaryCategory возвращает категорию зарплаты работника.*/
    public String getSalaryCategory() {

        return salaryCategory;
    }

  /**  Метод getExperienceEmploy возвращает опыт работы работника.*/
    public Integer getExperienceEmploy() {

        return experienceEmploy;
    }

    /**  Переопределенный метод equals() используется для сравнения экземпляров класса Worker на равенство.
      Два экземпляра считаются равными, если их ИДНП, имя, фамилия, должность, категория зарплаты и опыт работы совпадают.*/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Worker that = (Worker) o;
        return idnp == that.idnp &&
                nameEmploy.equals(that.nameEmploy) &&
                surnameEmploy.equals(that.surnameEmploy) &&
                positionEmploy.equals(that.positionEmploy) &&
                salaryCategory.equals(that.salaryCategory) &&
                experienceEmploy.equals(that.experienceEmploy);
    }

/**        Переопределенный метод hashCode() используется для генерации хеш-кода экземпляра класса Worker.
        Хеш-код используется в HashMap и HashSet для быстрого поиска элементов.*/
    @Override
    public int hashCode() {
        return Objects.hash(idnp);
    }

/**        Переопределенный метод toString() используется для вывода информации о работнике в форматированном виде.*/
    @Override
    public String toString() {
        return String.format(
                "%s\t%s\t%s\t%s\t%s\t%s",
                idnp,
                nameEmploy,
                surnameEmploy,
                positionEmploy,
                salaryCategory,
                experienceEmploy
        );
    }
}
