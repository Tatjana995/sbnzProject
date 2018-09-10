import { Component } from '../model/component';

export interface Medicine{
    id:any,
    name:string,
    group_med:string,
    components:Component[]
}