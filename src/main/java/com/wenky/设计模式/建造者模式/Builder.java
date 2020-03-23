package com.wenky.设计模式.建造者模式;

/**
 * @program: design-patterns
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-05-28 14:40
 **/
public class Builder {
     class Student {
        String name;
        int number;
        String sex;
        int age;
        String school;

        public Student () {
        }

        public Student (StudentBuilder builder) {
            this.age = builder.getAge();
            this.name = builder.getName();
            this.number = builder.getNumber();
            this.sex = builder.getSex();
            this.school = builder.getSchool();
        }

        class StudentBuilder {
            String name;
            int number;
            String sex;
            int age;
            String school;

            public String getName() {
                return name;
            }

            public StudentBuilder setName(String name) {
                this.name = name;
                return this;
            }

            public int getNumber() {
                return number;
            }

            public StudentBuilder setNumber(int number) {
                this.number = number;
                return this;
            }

            public String getSex() {
                return sex;
            }

            public StudentBuilder setSex(String sex) {
                this.sex = sex;
                return this;
            }

            public int getAge() {
                return age;
            }

            public StudentBuilder setAge(int age) {
                this.age = age;
                return this;
            }

            public String getSchool() {
                return school;
            }

            public StudentBuilder setSchool(String school) {
                this.school = school;
                return this;
            }

            public Student build() {
                return new Student(this);
            }
        }
    }

  public static void main(String[] args) {
      /**
       * 1.将Student和StudentBuilder均设为静态内部类
       */
      //Student student = new Student.StudentBuilder().setAge(1).build();

      /**
       * 2.Student和StudentBuilder均为非静态内部类
       */
      Student student =new Builder().new Student().new StudentBuilder().setAge(1).build();
      System.out.println(student.age);
  }
}
