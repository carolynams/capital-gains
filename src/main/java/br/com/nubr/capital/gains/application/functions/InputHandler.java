package br.com.nubr.capital.gains.application.functions;

import br.com.nubr.capital.gains.application.entity.Input;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class InputHandler {

    /**
     * This method handles the input from a BufferedReader and returns a list of lists of Input objects.
     * Each list inside the main list represents the operations for a given stock.
     * The method uses the Gson library to parse the JSON input string into Input objects.
     *
     * @param reader BufferedReader object containing the input data
     * @return List of lists of Input objects
     */
    @SneakyThrows
    public static List<List<Input>> inputHandle(BufferedReader reader) {
        var gson = new Gson();
        List<List<Input>> result = new ArrayList<>();

        String[] inputArray = readInputLines(reader).replace("\n", "").split("]");
        for (String s : inputArray) {
            String jsonStr = s + "]";
            Type listType = new TypeToken<ArrayList<Input>>() {
            }.getType();
            List<Input> inputs = gson.fromJson(jsonStr, listType);
            result.add(inputs);
        }
        return result;
    }

    /**
     * This method reads each line from a BufferedReader and concatenates them into a single string.
     * It also removes any double commas that may be present in the input data.
     *
     * @param reader BufferedReader object containing the input data
     * @return A single string with all the input data
     * @throws IOException if there is an error reading the input data
     */
    private static String readInputLines(BufferedReader reader) throws IOException {
        var sb = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.isEmpty()) {
                break;
            }
            sb.append(line.replace(",,", ","));
        }
        return sb.toString();
    }
}
