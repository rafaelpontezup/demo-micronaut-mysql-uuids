package br.com.zup.edu

import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository
import java.util.*

@Repository
interface ProposalRepository : JpaRepository<Proposal, UUID> {

    fun findByIdAndCustomerId(id: UUID, customerId: UUID): Optional<Proposal>
    
}