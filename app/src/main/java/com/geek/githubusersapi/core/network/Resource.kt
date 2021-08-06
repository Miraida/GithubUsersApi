package com.geek.githubusersapi.core.network

class Resource<out T> (val status: Status,val data:T?,val msg:String?,val code:Int?) {
    companion object{
        fun<T> success(data:T?,code: Int?):Resource<T?>{
            return Resource(Status.SUCCESS,data,null,code)
        }
        fun<T> error(msg: String?,code: Int?):Resource<T?>{
            return Resource(Status.ERROR,null,msg,code)
        }
        fun<T> loading():Resource<T?>{
           return Resource(Status.LOADING,null,null,null)
        }
    }
}