import myGroupId51.jd2_homework_7.Utils.HibernateUtil;
import myGroupId51.jd2_homework_7.entity.Address;
import myGroupId51.jd2_homework_7.entity.HomeTask;
import myGroupId51.jd2_homework_7.entity.Task;
import myGroupId51.jd2_homework_7.entity.WorkTask;

import javax.persistence.EntityManager;
import java.util.Date;

public class AppTask {
    public static void main(String[] args) {
        Task task = Task.builder()
                .name("Образец работы")
                .description("Образец описания")
                .build();

        Address address = Address.builder()
                .street("ул. Воронянского")
                .city("Минск")
                .build();

        HomeTask homeTask = HomeTask.builder()
                .name("ДЗ №7")
                .description("Hibernate - 3 стратегии наследования")
                .startDate(new Date(2024, 12, 4))
                .endDate(new Date(2024, 12, 10))
                .address(address)
                .build();

        WorkTask workTask = WorkTask.builder()
                .name("автомеханик")
                .description("Ремонт автомобилей, шиномонтаж")
                .cost(3124.35)
                .build();

        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(task);
        em.persist(homeTask);
        em.persist(workTask);
        em.getTransaction().commit();

        em.close();
        HibernateUtil.close();

    }
}
