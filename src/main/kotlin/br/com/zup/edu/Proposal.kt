package br.com.zup.edu

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Proposal(
    val name: String,
    @Column(columnDefinition = "binary(16)")
    val customerId: UUID
) {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "binary(16)")
    val id: UUID? = null

}