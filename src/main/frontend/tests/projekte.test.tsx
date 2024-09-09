import {describe, expect, it} from "vitest";
import {render, screen} from "@testing-library/react";
import Projekte from "Frontend/views/projekte";

describe("Projekte Akzeptanztest", () => {
  it("should render", () => {
    render(<Projekte/>);
    expect(screen.getByRole("title")).to.exist;
  });
});