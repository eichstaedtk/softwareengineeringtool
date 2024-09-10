import {ViewConfig} from '@vaadin/hilla-file-router/types.js';
import {useSignal} from '@vaadin/hilla-react-signals';

export const config: ViewConfig = {
  menu: {order: 0, icon: 'line-awesome/svg/globe-solid.svg'},
  title: 'Dashboard',
};

export default function DashboardView() {
  const name = useSignal('');

  return (
      <>
        <h1>Dashboard</h1>
      </>
  );
}
