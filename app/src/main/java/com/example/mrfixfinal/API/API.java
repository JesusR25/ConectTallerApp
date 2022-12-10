package com.example.mrfixfinal.API;

import com.example.mrfixfinal.Objetos.Detalle;
import com.example.mrfixfinal.Objetos.Producto;
import com.example.mrfixfinal.Objetos.User;
import com.example.mrfixfinal.Objetos.Vehiculo;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface API {
    @FormUrlEncoded
    @POST("API/createUser")
    Call<ResponseBody> createUser(
            @Field("NombreCliente") String Nombre,
            @Field("ApePatCliente") String ApePat,
            @Field("ApeMatCliente") String ApeMat,
            @Field("CorreoCliente") String Correo,
            @Field("TelefonoCliente") String Celular,
            @Field("Username") String Usuario,
            @Field("Contrasena") String Contrasena
    );

    @FormUrlEncoded
    @POST("API/userLogin")
    Call<User> userLogin(
            @Field("CorreoCliente") String CorreoCliente,
            @Field("Contrasena") String Contrasena
    );

    @FormUrlEncoded
    @POST("API/cliente")
    Call<User> getUser(
            @Field("IDCliente") String IDCliente
    );

    @GET("API/productos")
    Call<List<Producto>> getProductos();

    //Nuevo en api
    @GET("API/productosAsc")
    Call<List<Producto>> getProdAsc();
    //Nuevo en api
    @GET("API/productosDesc")
    Call<List<Producto>> getProdDesc();
    //Nuevo en api
    @GET("API/productosAlfa")
    Call<List<Producto>> getProdAlfa();

    @FormUrlEncoded
    @POST("API/vehiculo/consultarVehiMov")
    Call<List<Vehiculo>> getVehiculosCliente(
            @Field("IDCliente") String IDCliente
    );

    //Nuevo en api
    @FormUrlEncoded
    @POST("API/reparaciones/consultarMov")
    Call<Detalle> getDetalle(
            @Field("IDReparacion") String IDReparacion
    );

    @FormUrlEncoded
    @POST("API/reparacionesVehi")
    Call<List<Detalle>> getDetalleVehiculos(
            @Field("IDVehiculo") String IDVehiculo
    );

    //Nuevo en api
    @FormUrlEncoded
    @POST("API/vehiculo/consultarMov")
    Call<Vehiculo> getVehiculo(
            @Field("IDVehiculo") String IDVehiculo
    );



    @GET("API/detalles")
    Call<List<Detalle>> getDetalles();
}
