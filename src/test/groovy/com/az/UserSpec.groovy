package com.az

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(User)
class UserSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {

        println "test something calling "

        expect:"fixed"
            true == true
    }

    void "username must have minimum 5 characters"() {

        when: 'username must have 5 characters'
        def user = new User(username:'bala', email:'balaj@gmail.com', firstName : 'balaji', lastName : 'mani', password : 'balaji')

        then: 'validation should fail'
        user.validate() == false

        println "print errors"
        user.errors.allErrors.each { println it }

        when: 'username must have 5 characters'
        user = new User(username:'balaji', email:'balaj@gmail.com', firstName : 'balaji', lastName : 'mani', password : 'balaji')

        then: 'validation should fail'
        user.validate() == true
    }

}
