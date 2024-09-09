import { _getPropertyModel as _getPropertyModel_1, makeObjectEmptyValueCreator as makeObjectEmptyValueCreator_1, ObjectModel as ObjectModel_1, StringModel as StringModel_1 } from "@vaadin/hilla-lit-form";
import type Projekt_1 from "./Projekt.js";
class ProjektModel<T extends Projekt_1 = Projekt_1> extends ObjectModel_1<T> {
    static override createEmptyValue = makeObjectEmptyValueCreator_1(ProjektModel);
    get id(): StringModel_1 {
        return this[_getPropertyModel_1]("id", (parent, key) => new StringModel_1(parent, key, true, { meta: { javaType: "java.lang.String" } }));
    }
    get name(): StringModel_1 {
        return this[_getPropertyModel_1]("name", (parent, key) => new StringModel_1(parent, key, true, { meta: { javaType: "java.lang.String" } }));
    }
    get vision(): StringModel_1 {
        return this[_getPropertyModel_1]("vision", (parent, key) => new StringModel_1(parent, key, true, { meta: { javaType: "java.lang.String" } }));
    }
    get erstellDatum(): StringModel_1 {
        return this[_getPropertyModel_1]("erstellDatum", (parent, key) => new StringModel_1(parent, key, true, { meta: { javaType: "java.time.LocalDateTime" } }));
    }
}
export default ProjektModel;
