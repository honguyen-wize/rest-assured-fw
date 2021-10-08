package samples.payload;

public class Payload {
    public static String getPlacePayload(){
        return "{\n" +
                "  \"location\": {\n" +
                "    \"lat\": -38.383494,\n" +
                "    \"lng\": 33.427362\n" +
                "  },\n" +
                "  \"accuracy\": 50,\n" +
                "  \"name\": \"Ho C6.02 from Payload\",\n" +
                "  \"phone_number\": \"(+91) 983 893 3937\",\n" +
                "  \"address\": \"29, side layout, cohen 09\",\n" +
                "  \"types\": [\n" +
                "    \"shoe park\",\n" +
                "    \"shop\"\n" +
                "  ],\n" +
                "  \"website\": \"http://google.com\",\n" +
                "  \"language\": \"French-IN\"\n" +
                "}";
    }

    public static String mockPayload(){
        return "{\n" +
                "\t\"dashboard\": {\n" +
                "\t\t\"purchaseAmount\": 910,\n" +
                "\t\t\"website\": \"rahulshettyacademy.com\"\n" +
                "\t},\n" +
                "\t\"courses\": [\n" +
                "\t\t{\n" +
                "\t\t\t\"title\": \"Selenium Python\",\n" +
                "\t\t\t\"price\": 50,\n" +
                "\t\t\t\"copies\": 6\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"title\": \"Cypress\",\n" +
                "\t\t\t\"price\": 40,\n" +
                "\t\t\t\"copies\": 4\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"title\": \"RPA\",\n" +
                "\t\t\t\"price\": 45,\n" +
                "\t\t\t\"copies\": 10\n" +
                "\t\t}\n" +
                "\t]\n" +
                "}";
    }

    public static String getBookPayLoad(String isbn, String aisle){
        return "{\n" +
                "\"name\":\"Learn RestAssured New Editor\",\n" +
                "\"isbn\":\""+ isbn +"\",\n" +
                "\"aisle\":\"" + aisle + "\",\n" +
                "\"author\":\"Ho Nguyen\"\n" +
                "}";
    }

    public static String getComplexPayload(){
        return "[\n" +
                "    {\n" +
                "      \"isbn\": \"9781593275846\",\n" +
                "      \"title\": \"Eloquent JavaScript, Second Edition\",\n" +
                "      \"subtitle\": \"A Modern Introduction to Programming\",\n" +
                "      \"author\": \"Marijn Haverbeke\",\n" +
                "      \"published\": \"2014-12-14T00:00:00.000Z\",\n" +
                "      \"publisher\": \"No Starch Press\",\n" +
                "      \"pages\": 472,\n" +
                "      \"description\": \"JavaScript lies at the heart of almost every modern web application, from social apps to the newest browser-based games. Though simple for beginners to pick up and play with, JavaScript is a flexible, complex language that you can use to build full-scale applications.\",\n" +
                "      \"website\": \"https://eloquentjavascript.net/\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"isbn\": \"9781449331818\",\n" +
                "      \"title\": \"Learning JavaScript Design Patterns\",\n" +
                "      \"subtitle\": \"A JavaScript and jQuery Developer's Guide\",\n" +
                "      \"author\": \"Addy Osmani\",\n" +
                "      \"published\": \"2012-07-01T00:00:00.000Z\",\n" +
                "      \"publisher\": \"O'Reilly Media\",\n" +
                "      \"pages\": 254,\n" +
                "      \"description\": \"With Learning JavaScript Design Patterns, you'll learn how to write beautiful, structured, and maintainable JavaScript by applying classical and modern design patterns to the language. If you want to keep your code efficient, more manageable, and up-to-date with the latest best practices, this book is for you.\",\n" +
                "      \"website\": \"https://www.addyosmani.com/resources/essentialjsdesignpatterns/book/\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"isbn\": \"9781449365035\",\n" +
                "      \"title\": \"Speaking JavaScript\",\n" +
                "      \"subtitle\": \"An In-Depth Guide for Programmers\",\n" +
                "      \"author\": \"Axel Rauschmayer\",\n" +
                "      \"published\": \"2014-02-01T00:00:00.000Z\",\n" +
                "      \"publisher\": \"O'Reilly Media\",\n" +
                "      \"pages\": 460,\n" +
                "      \"description\": \"Like it or not, JavaScript is everywhere these days-from browser to server to mobile-and now you, too, need to learn the language or dive deeper than you have. This concise book guides you into and through JavaScript, written by a veteran programmer who once found himself in the same position.\",\n" +
                "      \"website\": \"https://speakingjs.com/\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"isbn\": \"9781491950296\",\n" +
                "      \"title\": \"Programming JavaScript Applications\",\n" +
                "      \"subtitle\": \"Robust Web Architecture with Node, HTML5, and Modern JS Libraries\",\n" +
                "      \"author\": \"Eric Elliott\",\n" +
                "      \"published\": \"2014-07-01T00:00:00.000Z\",\n" +
                "      \"publisher\": \"O'Reilly Media\",\n" +
                "      \"pages\": 254,\n" +
                "      \"description\": \"Take advantage of JavaScript's power to build robust web-scale or enterprise applications that are easy to extend and maintain. By applying the design patterns outlined in this practical book, experienced JavaScript developers will learn how to write flexible and resilient code that's easier-yes, easier-to work with as your code base grows.\",\n" +
                "      \"website\": \"https://chimera.labs.oreilly.com/books/1234000000262/index.html\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"isbn\": \"9781593277574\",\n" +
                "      \"title\": \"Understanding ECMAScript 6\",\n" +
                "      \"subtitle\": \"The Definitive Guide for JavaScript Developers\",\n" +
                "      \"author\": \"Nicholas C. Zakas\",\n" +
                "      \"published\": \"2016-09-03T00:00:00.000Z\",\n" +
                "      \"publisher\": \"No Starch Press\",\n" +
                "      \"pages\": 352,\n" +
                "      \"description\": \"ECMAScript 6 represents the biggest update to the core of JavaScript in the history of the language. In Understanding ECMAScript 6, expert developer Nicholas C. Zakas provides a complete guide to the object types, syntax, and other exciting changes that ECMAScript 6 brings to JavaScript.\",\n" +
                "      \"website\": \"https://leanpub.com/understandinges6/read\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"isbn\": \"9781491904244\",\n" +
                "      \"title\": \"You Don't Know JS\",\n" +
                "      \"subtitle\": \"ES6 & Beyond\",\n" +
                "      \"author\": \"Kyle Simpson\",\n" +
                "      \"published\": \"2015-12-27T00:00:00.000Z\",\n" +
                "      \"publisher\": \"O'Reilly Media\",\n" +
                "      \"pages\": 278,\n" +
                "      \"description\": \"No matter how much experience you have with JavaScript, odds are you don’t fully understand the language. As part of the 'You Don’t Know JS' series, this compact guide focuses on new features available in ECMAScript 6 (ES6), the latest version of the standard upon which JavaScript is built.\",\n" +
                "      \"website\": \"https://github.com/getify/You-Dont-Know-JS/tree/master/es6%20&%20beyond\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"isbn\": \"9781449325862\",\n" +
                "      \"title\": \"Git Pocket Guide\",\n" +
                "      \"subtitle\": \"A Working Introduction\",\n" +
                "      \"author\": \"Richard E. Silverman\",\n" +
                "      \"published\": \"2013-08-02T00:00:00.000Z\",\n" +
                "      \"publisher\": \"O'Reilly Media\",\n" +
                "      \"pages\": 234,\n" +
                "      \"description\": \"This pocket guide is the perfect on-the-job companion to Git, the distributed version control system. It provides a compact, readable introduction to Git for new users, as well as a reference to common commands and procedures for those of you with Git experience.\",\n" +
                "      \"website\": \"https://chimera.labs.oreilly.com/books/1230000000561/index.html\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"isbn\": \"9781449337711\",\n" +
                "      \"title\": \"Designing Evolvable Web APIs with ASP.NET\",\n" +
                "      \"subtitle\": \"Harnessing the Power of the Web\",\n" +
                "      \"author\": \"Glenn Block, et al.\",\n" +
                "      \"published\": \"2014-04-07T00:00:00.000Z\",\n" +
                "      \"publisher\": \"O'Reilly Media\",\n" +
                "      \"pages\": 538,\n" +
                "      \"description\": \"Design and build Web APIs for a broad range of clients—including browsers and mobile devices—that can adapt to change over time. This practical, hands-on guide takes you through the theory and tools you need to build evolvable HTTP services with Microsoft’s ASP.NET Web API framework. In the process, you’ll learn how design and implement a real-world Web API.\",\n" +
                "      \"website\": \"https://chimera.labs.oreilly.com/books/1234000001708/index.html\"\n" +
                "    }\n" +
                "  ]";
    }
}
