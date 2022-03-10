var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "32",
        "ok": "32",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "129",
        "ok": "129",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "1132",
        "ok": "1132",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "379",
        "ok": "379",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "277",
        "ok": "277",
        "ko": "-"
    },
    "percentiles1": {
        "total": "327",
        "ok": "327",
        "ko": "-"
    },
    "percentiles2": {
        "total": "539",
        "ok": "539",
        "ko": "-"
    },
    "percentiles3": {
        "total": "909",
        "ok": "909",
        "ko": "-"
    },
    "percentiles4": {
        "total": "1073",
        "ok": "1073",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 29,
    "percentage": 91
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 3,
    "percentage": 9
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "1.455",
        "ok": "1.455",
        "ko": "-"
    }
},
contents: {
"req_opening-compute-a77f4": {
        type: "REQUEST",
        name: "Opening computers page",
path: "Opening computers page",
pathFormatted: "req_opening-compute-a77f4",
stats: {
    "name": "Opening computers page",
    "numberOfRequests": {
        "total": "16",
        "ok": "16",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "510",
        "ok": "510",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "1132",
        "ok": "1132",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "625",
        "ok": "625",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "181",
        "ok": "181",
        "ko": "-"
    },
    "percentiles1": {
        "total": "541",
        "ok": "541",
        "ko": "-"
    },
    "percentiles2": {
        "total": "603",
        "ok": "603",
        "ko": "-"
    },
    "percentiles3": {
        "total": "990",
        "ok": "990",
        "ko": "-"
    },
    "percentiles4": {
        "total": "1104",
        "ok": "1104",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 13,
    "percentage": 81
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 3,
    "percentage": 19
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "0.727",
        "ok": "0.727",
        "ko": "-"
    }
}
    },"req_opening-new-com-919cb": {
        type: "REQUEST",
        name: "Opening new computers page",
path: "Opening new computers page",
pathFormatted: "req_opening-new-com-919cb",
stats: {
    "name": "Opening new computers page",
    "numberOfRequests": {
        "total": "16",
        "ok": "16",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "129",
        "ok": "129",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "143",
        "ok": "143",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "133",
        "ok": "133",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "4",
        "ok": "4",
        "ko": "-"
    },
    "percentiles1": {
        "total": "133",
        "ok": "133",
        "ko": "-"
    },
    "percentiles2": {
        "total": "135",
        "ok": "135",
        "ko": "-"
    },
    "percentiles3": {
        "total": "142",
        "ok": "142",
        "ko": "-"
    },
    "percentiles4": {
        "total": "143",
        "ok": "143",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 16,
    "percentage": 100
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "0.727",
        "ok": "0.727",
        "ko": "-"
    }
}
    }
}

}

function fillStats(stat){
    $("#numberOfRequests").append(stat.numberOfRequests.total);
    $("#numberOfRequestsOK").append(stat.numberOfRequests.ok);
    $("#numberOfRequestsKO").append(stat.numberOfRequests.ko);

    $("#minResponseTime").append(stat.minResponseTime.total);
    $("#minResponseTimeOK").append(stat.minResponseTime.ok);
    $("#minResponseTimeKO").append(stat.minResponseTime.ko);

    $("#maxResponseTime").append(stat.maxResponseTime.total);
    $("#maxResponseTimeOK").append(stat.maxResponseTime.ok);
    $("#maxResponseTimeKO").append(stat.maxResponseTime.ko);

    $("#meanResponseTime").append(stat.meanResponseTime.total);
    $("#meanResponseTimeOK").append(stat.meanResponseTime.ok);
    $("#meanResponseTimeKO").append(stat.meanResponseTime.ko);

    $("#standardDeviation").append(stat.standardDeviation.total);
    $("#standardDeviationOK").append(stat.standardDeviation.ok);
    $("#standardDeviationKO").append(stat.standardDeviation.ko);

    $("#percentiles1").append(stat.percentiles1.total);
    $("#percentiles1OK").append(stat.percentiles1.ok);
    $("#percentiles1KO").append(stat.percentiles1.ko);

    $("#percentiles2").append(stat.percentiles2.total);
    $("#percentiles2OK").append(stat.percentiles2.ok);
    $("#percentiles2KO").append(stat.percentiles2.ko);

    $("#percentiles3").append(stat.percentiles3.total);
    $("#percentiles3OK").append(stat.percentiles3.ok);
    $("#percentiles3KO").append(stat.percentiles3.ko);

    $("#percentiles4").append(stat.percentiles4.total);
    $("#percentiles4OK").append(stat.percentiles4.ok);
    $("#percentiles4KO").append(stat.percentiles4.ko);

    $("#meanNumberOfRequestsPerSecond").append(stat.meanNumberOfRequestsPerSecond.total);
    $("#meanNumberOfRequestsPerSecondOK").append(stat.meanNumberOfRequestsPerSecond.ok);
    $("#meanNumberOfRequestsPerSecondKO").append(stat.meanNumberOfRequestsPerSecond.ko);
}
