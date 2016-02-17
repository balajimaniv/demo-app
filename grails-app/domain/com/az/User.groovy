package com.az

class User {

    String username
    String email
    String firstName
    String lastName
    String password
    String uid

    static constraints = {

        username size: 5..15, blank: false, unique: true
        password size: 5..15, blank: false
        email email: true, blank: false
        uid nullable: true, blank : true

    }
    def afterInsert = {

        println "********after insert***********"
        generateUid();
    }
    def beforeUpdate  = {

        println "********before upadate***********"
        generateUid();
    }
    def generateUid() {

        // first and last letter of username plus ID
        println "first :"+this.username.take(1)
        println "last :"+this.username.drop(this.username.length()-1)
        this.uid = this.username.take(1)+ this.username.drop(username.length()-1) + this.id.toString();
        println("After save : "+this.uid)
    }
}
