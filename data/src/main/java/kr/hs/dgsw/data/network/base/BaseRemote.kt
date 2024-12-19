package kr.hs.dgsw.data.network.base

abstract class BaseRemote<Service>: Request {
    protected abstract val service: Service
}