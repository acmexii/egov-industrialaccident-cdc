package contracts.rest

org.springframework.cloud.contract.spec.Contract.make {
    request {
        method 'GET'
        url ('/assessments/1')
        headers {
            contentType(applicationJson())
        }
    }
    response {
        status 200
        body(
                id: 1,
                accidentId: 1,
                businessCode: "bc_1",
                employeeId: "user01",
                assessorId: 1,
                hospitalCode: "hp_1",
                doctorNote: "골절",
        )
        bodyMatchers {
            jsonPath('$.id', byRegex(nonEmpty()).asLong())
            jsonPath('$.accidentId', byRegex(nonEmpty()).asLong())
            jsonPath('$.businessCode', byRegex(nonEmpty()).asString())
            jsonPath('$.employeeId', byRegex(nonEmpty()).asString())
            jsonPath('$.assessorId', byRegex(nonEmpty()).asLong())
            jsonPath('$.hospitalCode', byRegex(nonEmpty()).asString())
            jsonPath('$.doctorNote', byRegex(nonEmpty()).asString())
        }
        headers {
            contentType(applicationJson())
        }
    }
}