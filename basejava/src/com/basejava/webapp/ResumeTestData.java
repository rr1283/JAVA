package com.basejava.webapp;

import com.basejava.webapp.model.*;
import com.basejava.webapp.storage.MapResumeStorage;

import java.time.Month;

public class ResumeTestData {

    static final MapResumeStorage MAP_STORAGE = new MapResumeStorage();

    public static void main(String[] args) {

        final String UUID_1 = "uuid1";
        final String UUID_2 = "uuid2";
        final String UUID_3 = "uuid3";
        final String UUID_4 = "uuid4";

        final String FULL_NAME1 = "Иванов Иван Иванович";
        final String FULL_NAME2 = "Петров Иван Иванович";
        final String FULL_NAME3 = "Смирнов Иван Иванович";
        final String FULL_NAME4 = "Синий Иван Иванович";

        final Resume RESUME_1;
        final Resume RESUME_2;
        final Resume RESUME_3;
        final Resume RESUME_4;

        RESUME_1 = new Resume(UUID_1, FULL_NAME1);
        RESUME_1.addSection(SectionType.OBJECTIVE, new TextSection("Objective1"));
        RESUME_1.addSection(SectionType.PERSONAL, new TextSection("Personal1"));
        RESUME_1.addSection(SectionType.ACHIEVEMENT, new ListSection("Achievement1", "Achievement2"));
        //   RESUME_1.addSection(SectionType.QUALIFICATIONS, new ListSection("Qualifications1","Qualifications2"));
        RESUME_1.addSection(SectionType.EXPERIENCE, new OrganizationSection(
                new Organization("Organization11",
                        "http://Organization11.ru",
                        new Period(1996, Month.JANUARY,
                                2000, Month.DECEMBER,
                                "position1",
                                "content1"),
                        new Period(2001, Month.MARCH,
                                2005, Month.JANUARY,
                                "position2",
                                "content2")
                )));
        RESUME_1.addSection(SectionType.EDUCATION,
                new OrganizationSection(
                        new Organization("Institute",
                                null,
                                new Period(1996, Month.JANUARY,
                                        2000, Month.DECEMBER,
                                        "aspirant",
                                        null),
                                new Period(2001, Month.MARCH,
                                        2005, Month.JANUARY,
                                        "student",
                                        "IT facultet")),
                        new Organization("Organization12",
                                "http://Organization12.ru")));

        RESUME_1.addContact(ContactType.SKYPE, "skype2");
        RESUME_1.addContact(ContactType.PHONE, "22222");
        RESUME_1.addSection(SectionType.EXPERIENCE,
                new OrganizationSection(
                        new Organization("Organization3", "http://Organization3.ru",
                                new Period(2001, Month.MARCH,
                                        2005, Month.JANUARY,
                                        "position3",
                                        "content3"))));

        RESUME_2 = new Resume(UUID_2, FULL_NAME2);
        RESUME_3 = new Resume(UUID_3, FULL_NAME3);
        RESUME_4 = new Resume(UUID_4, FULL_NAME4);

        System.out.println("save");
        MAP_STORAGE.save(RESUME_1);
        MAP_STORAGE.save(RESUME_2);
        MAP_STORAGE.save(RESUME_3);
        MAP_STORAGE.save(RESUME_4);

        System.out.println("save");
        printAll();
        MAP_STORAGE.update(RESUME_3);
        System.out.println("update");

        System.out.println("Size: " + MAP_STORAGE.size());
//
        System.out.println("Get r1: " + MAP_STORAGE.get(RESUME_1.getUuid()));
//
        //  System.out.println("Get dummy: " + MAP_STORAGE.get("dummy"));
//
        printAll();
//
        MAP_STORAGE.delete(RESUME_1.getUuid());
        System.out.println("delete r1");
        System.out.println("Size: " + MAP_STORAGE.size());
        printAll();
        MAP_STORAGE.clear();
        printAll();
//
        System.out.println("Size: " + MAP_STORAGE.size());
    }

    static void printAll() {
        System.out.println("\nGet All");
        for (Resume r : MAP_STORAGE.getAllSorted()) {
            System.out.println(r);
        }
    }
}
