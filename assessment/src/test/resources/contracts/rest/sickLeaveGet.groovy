package contracts.rest

org.springframework.cloud.contract.spec.Contract.make {
    request {
        method 'GET'
        url ('/sickLeaves/1')
        headers {
            contentType(applicationJson())
        }
    }
    response {
        status 200
        body(
                id: 1,
                accessmentId: 1,
                accidentId: 1,
                businessCode: "bc_1",
                employeeId: "user01",
                period: 10,
                status: "휴업급여요청됨",
        )
        bodyMatchers {
            jsonPath('$.id', byRegex(nonEmpty()).asLong())
            jsonPath('$.accessmentId', byRegex(nonEmpty()).asLong())
            jsonPath('$.accidentId', byRegex(nonEmpty()).asLong())
            jsonPath('$.businessCode', byRegex(nonEmpty()).asString())
            jsonPath('$.employeeId', byRegex(nonEmpty()).asString())
            jsonPath('$.period', byRegex(nonEmpty()).asInteger())
            jsonPath('$.status', byRegex(nonEmpty()).asString())
        }
        headers {
            contentType(applicationJson())
        }
    }
}