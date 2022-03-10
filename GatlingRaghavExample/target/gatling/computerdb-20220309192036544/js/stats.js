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
        "total": "116",
        "ok": "116",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "1513",
        "ok": "1513",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "379",
        "ok": "379",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "298",
        "ok": "298",
        "ko": "-"
    },
    "percentiles1": {
        "total": "486",
        "ok": "486",
        "ko": "-"
    },
    "percentiles2": {
        "total": "518",
        "ok": "518",
        "ko": "-"
    },
    "percentiles3": {
        "total": "757",
        "ok": "757",
        "ko": "-"
    },
    "percentiles4": {
        "total": "1331",
        "ok": "1331",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 30,
    "percentage": 94
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 1,
    "percentage": 3
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 1,
    "percentage": 3
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "1.28",
        "ok": "1.28",
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
        "total": "485",
        "ok": "485",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "1513",
        "ok": "1513",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "600",
        "ok": "600",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "257",
        "ok": "257",
        "ko": "-"
    },
    "percentiles1": {
        "total": "516",
        "ok": "516",
        "ko": "-"
    },
    "percentiles2": {
        "total": "532",
        "ok": "532",
        "ko": "-"
    },
    "percentiles3": {
        "total": "1074",
        "ok": "1074",
        "ko": "-"
    },
    "percentiles4": {
        "total": "1425",
        "ok": "1425",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 14,
    "percentage": 88
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 1,
    "percentage": 6
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 1,
    "percentage": 6
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "0.64",
        "ok": "0.64",
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
        "total": "116",
        "ok": "116",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "618",
        "ok": "618",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "158",
        "ok": "158",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "119",
        "ok": "119",
        "ko": "-"
    },
    "percentiles1": {
        "total": "129",
        "ok": "129",
        "ko": "-"
    },
    "percentiles2": {
        "total": "133",
        "ok": "133",
        "ko": "-"
    },
    "percentiles3": {
        "total": "261",
        "ok": "261",
        "ko": "-"
    },
    "percentiles4": {
        "total": "547",
        "ok": "547",
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
        "total": "0.64",
        "ok": "0.64",
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
