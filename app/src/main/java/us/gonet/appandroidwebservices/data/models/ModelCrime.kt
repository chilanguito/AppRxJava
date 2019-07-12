package us.gonet.appandroidwebservices.data.models

data class ModelCrime(
    val age_range: String,
    val datetime: String,
    val gender: String,
    val involved_person: Boolean,
    val legislation: String,
    val location: Location,
    val object_of_search: String,
    val officer_defined_ethnicity: String,
    val operation: Any,
    val operation_name: Any,
    val outcome: String,
    val outcome_linked_to_object_of_search: Any,
    val outcome_object: OutcomeObject,
    val removal_of_more_than_outer_clothing: Boolean,
    val self_defined_ethnicity: String,
    val type: String
)