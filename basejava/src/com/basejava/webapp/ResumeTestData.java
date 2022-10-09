package com.basejava.webapp;

import com.basejava.webapp.model.*;

import java.time.Month;

import static com.basejava.webapp.model.ContactType.*;
import static com.basejava.webapp.model.SectionType.*;

public class ResumeTestData {

    public static void getFilledResume(String uuid, String full_name) {

        final Resume RESUME;
        final String UUID = uuid;
        final String FULL_NAME = full_name;

        RESUME = new Resume(UUID, FULL_NAME);

        RESUME.addContact(ContactType.SKYPE, "RomanPodkin");
        RESUME.addContact(GITHUB, "www.github.ru");
        RESUME.addContact(HOME_PAGE, "www.romanpodkin.ru");
        RESUME.addContact(LINKEDIN, "www.Linkedin.ru");
        RESUME.addContact(MAIL, "prv@mail.ru");
        RESUME.addContact(MOBILE, "+7(925) 614-60-44");
        RESUME.addContact(STACKOVERFLOW, "www.Stackoverflow.ru");
        RESUME.addContact(PHONE, "");
        RESUME.addContact(HOME_PHONE, "+7(495) 222-22-22");

        RESUME.addSection(SectionType.OBJECTIVE, new TextSection("Java Developer"));
        RESUME.addSection(SectionType.PERSONAL, new TextSection("Инициативность, обучаемость"));
        RESUME.addSection(SectionType.ACHIEVEMENT, new ListSection("Достижение1", "Достижение2"));
        RESUME.addSection(SectionType.QUALIFICATIONS, new ListSection("Qualifications1", "Qualifications2"));
        RESUME.addSection(SectionType.EXPERIENCE, new OrganizationSection(
                new Organization("ВТБ", "www.vtb.ru",
                        new Period(2000, Month.JANUARY, 2005, Month.DECEMBER, "PL/SQL Developer",
                                "Разработка серверной части приложения. Ревью кода. Администрирование БД Oracle 19"),
                        new Period(2005, Month.MARCH, 2007, Month.JANUARY, "Team Lead Группы разработки",
                                "Python, Java, Oracle, Postgres")
                )));
        RESUME.addSection(SectionType.EXPERIENCE, new OrganizationSection(
                new Organization("ПАО Сбербанк", "www.sberbank.ru",
                        new Period(2007, Month.MARCH, 2011, Month.JANUARY, "Java Developer",
                                "Разработка web приложений. Оптимизация кода")
                )));
        RESUME.addSection(SectionType.EDUCATION,
                new OrganizationSection(
                        new Organization("МГУ", "www.mgu.ru",
                                new Period(2000, Month.JANUARY, 2005, Month.DECEMBER, "Студент",
                                        "Информатика, вычислительные машины и комплексы"),
                                new Period(2005, Month.MARCH, 2011, Month.JANUARY, "Аспирант",
                                        "Информатика, вычислительные машины и комплексы")),
                        new Organization("МГТУ", "www.mgtu.ru")));

        //  printResume(RESUME);
    }

    static void printResume(Resume Resume) throws NullPointerException {
        Resume r = Resume;

        System.out.println(r.toString());
        System.out.println(PHONE.getTitle() + ": " + r.getContact(PHONE));
        System.out.println(MOBILE.getTitle() + ": " + r.getContact(MOBILE));
        System.out.println(HOME_PHONE.getTitle() + ": " + r.getContact(HOME_PHONE));
        System.out.println(SKYPE.getTitle() + ": " + r.getContact(SKYPE));
        System.out.println(MAIL.getTitle() + ": " + r.getContact(MAIL));
        System.out.println(LINKEDIN.getTitle() + ": " + r.getContact(LINKEDIN));
        System.out.println(GITHUB.getTitle() + ": " + r.getContact(GITHUB));
        System.out.println(STACKOVERFLOW.getTitle() + ": " + r.getContact(STACKOVERFLOW));
        System.out.println(HOME_PAGE.getTitle() + ": " + r.getContact(HOME_PAGE));
        System.out.println(QUALIFICATIONS.getTitle() + ": " + r.getSection(QUALIFICATIONS));
        System.out.println(ACHIEVEMENT.getTitle() + ": " + r.getSection(ACHIEVEMENT));
        System.out.println(OBJECTIVE.getTitle() + ": " + r.getSection(OBJECTIVE));
        System.out.println(EXPERIENCE.getTitle() + ": " + r.getSection(EXPERIENCE));
        System.out.println(EDUCATION.getTitle() + ": " + r.getSection(EDUCATION));
        System.out.println(PERSONAL.getTitle() + ": " + r.getSection(PERSONAL));
    }
}

