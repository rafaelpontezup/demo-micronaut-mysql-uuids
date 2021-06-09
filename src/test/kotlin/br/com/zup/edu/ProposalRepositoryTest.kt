package br.com.zup.edu

import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.util.*

@MicronautTest
class ProposalRepositoryTest(val repository: ProposalRepository) {

    val CUSTOMER_ID = UUID.randomUUID()

    @Test
    fun `should find by id`() {
        // scenario
        val proposal = repository.save(Proposal(
            name = "p1",
            customerId = CUSTOMER_ID
        ))

        // action
        val found = repository.findById(proposal.id)

        // validation
        with(found) {
            assertTrue(isPresent)
            assertEquals(proposal.id, get().id)
            assertEquals(CUSTOMER_ID, get().customerId)
        }
    }

    @Test
    fun `should find by id and customer id`() {
        // scenario
        val proposal = repository.save(Proposal(
            name = "p1",
            customerId = CUSTOMER_ID
        ))

        // action
        val found = repository.findByIdAndCustomerId(
            id = proposal.id!!,
            customerId = proposal.customerId
        )

        // validation
        with(found) {
            assertTrue(isPresent)
            assertEquals(proposal.id, get().id)
            assertEquals(CUSTOMER_ID, get().customerId)
        }
    }

}