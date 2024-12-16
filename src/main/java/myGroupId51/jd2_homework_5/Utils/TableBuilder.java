package myGroupId51.jd2_homework_5.Utils;

public class TableBuilder {
    private static String generateHorizontalBorder(int[] columnWidths) {
        StringBuilder border = new StringBuilder("+");
        for (int width : columnWidths) {
            border.append("-".repeat(width + 2));
            border.append("+");
        }
        return border.toString();
    }

    private static String generateHeaderRow(String[] headers, int[] columnWidths) {
        StringBuilder headerRow = new StringBuilder("|");
        for (int i = 0; i < headers.length; i++) {
            headerRow.append(String.format(" %-"+columnWidths[i]+"s |", headers[i]));
        }
        return headerRow.toString();
    }

    public static void printHeader(String[] headers, int[] columnWidths) {
        System.out.println(generateHorizontalBorder(columnWidths));
        System.out.println(generateHeaderRow(headers, columnWidths));
        System.out.println(generateHorizontalBorder(columnWidths));
    }

    public static void printEmployeeRow(String[] data, int[] columnWidths) {
        StringBuilder row = new StringBuilder("|");
        for (int i = 0; i < data.length; i++) {
            row.append(String.format(" %-"+columnWidths[i]+"s |", data[i]));
        }
        System.out.println(row);
    }

    public static void printFooter(int[] columnWidths) {
        System.out.println(generateHorizontalBorder(columnWidths));
    }
}


