package com.yathin.TableBookingApplication.Response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Response<T> {
    private boolean status;
    private String message;
    private T data;

    public static <T> Response<T> successResponse(T data, String message)
    {
        Response<T> response = new Response<>();
        response.setStatus(true);
        response.setMessage(message);
        response.setData(data);

        return response;
    }

    public static <T> Response<T> errorResponse(String message)
    {
        Response<T> response = new Response<>();
        response.setStatus(false);
        response.setMessage(message);
        response.setData(null);
        return response;
    }

}