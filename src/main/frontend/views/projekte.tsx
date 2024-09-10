import {ViewConfig} from '@vaadin/hilla-file-router/types.js';
import {TextArea} from '@vaadin/react-components/TextArea.js';
import {TextField} from "@vaadin/react-components/TextField.js";
import {useState} from "react";
import {useForm} from "@vaadin/hilla-react-form";
import ProjektModel from "Frontend/generated/de/eichstaedt/engineering/domain/ProjektModel";
import {Button} from '@vaadin/react-components/Button.js';
import {ProjektController} from "Frontend/generated/endpoints";

export const config: ViewConfig = {
  menu: {order: 1, icon: 'line-awesome/svg/file.svg'},
  title: 'Projekte'
};

export default function Projekte() {

  const [text, setText] = useState('Great job. This is excellent!');
  const charLimit = 200;
  const {model, submit, reset, field} = useForm(ProjektModel, {
    onSubmit: async (projekt) => {
      await ProjektController.saveProjekt(projekt);
      reset()
    }
  });

  return (
      <div className="flex flex-col h-full items-center p-l box-border">
        <h1 role={"title"}>Neues Projekt anlegen</h1>

        <TextField
            required
            minlength={3}
            maxlength={50}
            allowedCharPattern="[a-zA-Z]"
            label="Name"
            helperText="Bezeichnung des Projektes"
            {...field(model.name)}
        />
        <TextArea
            label="Projektvision"
            helperText="Vision des Projektes"
            maxlength={charLimit}
            {...field(model.vision)}
        />
        <Button onClick={submit}>Speichern</Button>
      </div>
  );
}
