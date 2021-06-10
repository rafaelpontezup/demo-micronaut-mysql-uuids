package br.com.zup.edu

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Proposal(
    val name: String,
    //
    @Column(columnDefinition = "binary(16)") // this works but uses a MySQL's specific type
    val customerId: UUID
) {

    @Id
    @GeneratedValue
    /**
     * By default Hibernate creates a column as BINARY(255) that works on INSERT but fails on SELECT
     * In fact, BINARY(16) works like a CHAR on MySQL:
     *  - https://dev.mysql.com/doc/refman/8.0/en/binary-varbinary.html
     */
    @Column(length = 16) // that works too and it's more compatible with other databases
    val id: UUID? = null

}