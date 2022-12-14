package com.example.csvfile.validators.data;
public record Line(int number, String id, String company, String rfc, String email, String phone, String foreing, String contact, String fiscalAddress) {

    public static Line toLine(final int lineNumber, final String value){

        // Split the line into fields
        final String[] fields = value.split(",");

        // Here we can create a valid line
        return new Line(lineNumber,
                get(fields,0),
                get(fields,1),
                get(fields,2),
                get(fields,3),
                get(fields,4),
                get(fields,5),
                get(fields,6),
                get(fields,7));
    }

    /**
     * Simple method to avoid {@link NullPointerException} if there
     * is a line with less than n fields
     *
     *
     */
    private static String get(final String[] fields, final int index){
        if(index < fields.length){
            return fields[index];
        }
        return null;
    }
}