package br.ifal.edu.projetowebv2.model;

import java.util.List;

class Student {
    String name;
    String email;
    String cpf;
    String password;
    String gender;
    String module;
    List<String> areaActings;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public List<String> getAreaActings() {
        return areaActings;
    }

    public void setAreaActings(List<String> areaActings) {
        this.areaActings = areaActings;
    }
}